package com.example.demo.controller;

import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.bean.Fruit;
import com.google.gson.Gson;

// 了解各種不同 URL 與參數的傳遞與接收
@RestController
@RequestMapping("/api")
public class ApiController {
	
	/**
	 * 1. 歡迎頁
	 * 路徑:/hello
	 * 路徑:/home
	 * 路徑:/welcome
	 * 網址:http://localhost:8080/api/hello
	 * 網址:http://localhost:8080/api/home
	 * 網址:http://localhost:8080/api/welcome
	 * */
	//@GetMapping("/hello")
	@GetMapping(value = {"/hello", "/home", "/welcome"})
	public String hello() {
		return "Hello Spring " + new Date();
	}
	
	/**
	 * 2. ?帶參數
	 * 路徑:/greet?name=John&age=18
	 * 路徑:/greet?name=Mary
	 * 網址:http://localhost:8080/api/greet?name=John&age=18
	 * 網址:http://localhost:8080/api/greet?name=Mary
	 * 限制:name 參數是一定要有的
	 *     age 參數是可選的(若沒有 age 參數則會有初始值 0)
	 * 備註:required = true 預設(可以不用寫)
	 *    若 @RequestParam 的 value = "name" 剛好等於 String name, 則 value = "name" 可以省略
	 *    範例: 
	 *    @RequestParam(value = "name", required = true) String name
	 *    改成 
	 *    @RequestParam(required = true) String name
	 *    或
	 *    @RequestParam String name
	 * */
	@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", required = true) String name,
						@RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
		
		return String.format("Hi %s, age:%d", name, age);
	}
	
	/**
	 * 3.Lab 練習 I
	 * 路徑:/add?x=10&y=20
	 * 路徑:/add?y=20
	 * 路徑:/add
	 * 網址:http://localhost:8080/api/add?x=10&y=20 => 執行結果 => result = 30
	 * 網址:http://localhost:8080/api/add?y=20 => 執行結果 => result = 20
	 * 網址:http://localhost:8080/api/add => 執行結果 => result = 0
	 * 以下請設計一個方法滿足上述需求 ?
	 * */
	@GetMapping("/add")
	public String add(@RequestParam(defaultValue = "0") int x,
					  @RequestParam(defaultValue = "0") int y) {
		int result = x + y;
		return String.format("x=%d y=%d result = %d", x, y, result);
	}
	
	/**
	 * 3.Lab 練習 II
	 * 路徑:/bmi?h=170&w=60
	 * 網址:http://localhost:8080/api/bmi?h=170&w=60 => 執行結果 => bmi = 20.76
	 * 
	 * 路徑:/bmi?h=170
	 * 網址:http://localhost:8080/api/bmi?h=170 => 執行結果 => "體重未輸入"

	 * 路徑:/bmi
	 * 網址:http://localhost:8080/api/bmi => 執行結果 => "身高與體重未輸入"
	 * 
	 * 以下請設計一個方法滿足上述需求 ?
	 * */
	
	@GetMapping("/bmi")
	public String bmi(@RequestParam(required = false) Double h,
					  @RequestParam(required = false) Double w) {
		
		if(h == null && w == null) {
			return "身高與體重未輸入";
		} else if(h == null) {
			return "身高未輸入";
		} else if(w == null) {
			return "體重未輸入";
		}
		
		// 計算 bmi
		double bmi = w / Math.pow(h/100, 2);
		return String.format("bmi = %.2f", bmi);
	}
	
	/**
	 * 4. 同名多筆的資料
	 * 路徑:/age?age=17&age=21&age=20
	 * 網址:http://localhost:8080/api/age?age=17&age=21&age=20
	 * 計算出平均年齡 = ?
	 * 成年與未成年的年齡有哪些 ?
	 * */
	@GetMapping("/age")
	public String age(@RequestParam(value = "age", required = false) List<Integer> ages) {
		double average = 0.0;
		if(ages != null) {
			average = ages.stream().mapToInt(Integer::intValue).average().orElseGet(() -> 0.0);
		}
		// 利用分組來區分成年與未成年
		// true: 成年, false: 未成年
		Map<Boolean, List<Integer>> resultMap = ages.stream()
													.collect(Collectors.partitioningBy(age -> age >= 18));
		
		return String.format("平均年齡: %.1f 成年: %s 未成年: %s", 
							average, resultMap.get(true), resultMap.get(false));
	}
	
	
	/**
	 * 5. Lab 練習
	 * 路徑:/exam?score=80&score=100&score=50&score=70&score=30
	 * 網址:http://localhost:8080/api/exam?score=80&score=100&score=50&score=70&score=30
	 * 請自行設計一個方法可以得到
	 * 最高分 = ? 最低分 = ? 平均 = ? 總分 = ? 及格分數 = ? 不及格分數 = ?
	 * 提示使用: IntSummaryStatistics, Collectors.partitioningBy
	 * */
	@GetMapping("/exam")
	public String exam(@RequestParam(value = "score", required = false) List<Integer> scores)  {
		// 利用統計物件(最高分 = ? 最低分 = ? 平均 = ? 總分 = ?)
		IntSummaryStatistics stat = scores.stream().mapToInt(Integer::intValue).summaryStatistics();
		// 資料分組(及格分數 = ? 不及格分數 = ?)
		Map<Boolean, List<Integer>> resultMap = scores.stream()
								.collect(Collectors.partitioningBy(score -> score >= 60));
		return String.format("最高 = %d 最低 = %d 平均 = %.1f 總分 = %d 及格分數 = %s 不及格分數 = %s",
				stat.getMax(), stat.getMin(), stat.getAverage(), stat.getSum(),
				resultMap.get(true), resultMap.get(false));
	}
	
	/**
	 * 6. 多筆參數轉 Map
	 * 路徑: /product?name=Apple&price=50.5&amount=10
	 * 路徑: /product?name=Banana&price=35.5&amount=20
	 * 網址:http://localhost:8080/api/product?name=Apple&price=50.5&amount=10
	 * 網址:http://localhost:8080/api/product?name=Banana&price=35.5&amount=20
	 * */
	@GetMapping("/product")
	public String product(@RequestParam Map<String, Object> productMap) {
		return String.format("name: %s price: %s amount: %s", 
				productMap.get("name"), productMap.get("price"), productMap.get("amount"));
	}
	
	/**
	 * 7. 多筆參數轉 Bean
	 * 路徑: /fruit?name=Apple&price=50.5&amount=10
	 * 路徑: /fruit?name=Banana&price=35.5&amount=20
	 * 網址:http://localhost:8080/api/fruit?name=Apple&price=50.5&amount=10
	 * 網址:http://localhost:8080/api/fruit?name=Banana&price=35.5&amount=20
	 * 需要設計一個 Fruit 的物件
	 * */
	@GetMapping(value = "/fruit", produces = "application/json")
	public String fruit(Fruit fruit) {
		// 回應 json 格式
		Gson gson = new Gson();
		String json = gson.toJson(fruit); // 將 fruit 物件轉 json 字串
		return json;
	}
	
	/**
	 * 8. 參數路徑: @PathVariable
	 * 路徑: /score/80
	 * 路徑: /score/40
	 * 網址: http://localhost:8080/api/score/80
	 * 網址: http://localhost:8080/api/score/40
	 * 範例: 判定分數是否及格 ?
	 * */
	@GetMapping("/score/{value}")
	public String confirmScore(@PathVariable Integer value) {
		boolean isPass = (value >= 60); 
		String content = String.format("分數: %d 及格: %b", value, isPass);
		return content;
	}
	
	/**
	 * Lab. 參數路徑: @PathVariable
	 * 路徑: /fruit/1
	 * 路徑: /fruit/2
	 * 網址: http://localhost:8080/api/fruit/1
	 * 網址: http://localhost:8080/api/fruit/2
	 * 範例: 透過水果編號可以得到的水果名稱
	 * */
	@GetMapping("/fruit/{fruitId}")
	public String getFruit(@PathVariable Integer fruitId) {
		Map<Integer, String> fruits = Map.of(1, "蘋果", 2, "西瓜", 3, "番茄");
		String fruitName = fruits.get(fruitId);
		String content = String.format("編號: %d 名稱: %s", fruitId, fruitName);
		return content;
	}
	
	
	
}

