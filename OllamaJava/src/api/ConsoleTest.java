package api;

import okhttp3.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * 範例名稱：OllamaGenerateExample（使用 OkHttp3 版本）
 *
 * 說明：
 *  本程式示範如何使用 OkHttp3 HTTP 客戶端函式庫，
 *  向本機或同區網的 Ollama 伺服器發送 POST 請求，
 *  呼叫 /api/generate 端點以生成文字回應結果。
 *
 *  對應的 curl 範例如下：
 *  curl -X POST http://192.168.30.121:11434/api/generate \
 *   -H "Content-Type: application/json" \
 *   -d "{\"model\":\"qwen:0.5b-chat\",\"prompt\":\"請用中文介紹 Java 程式語言\",\"stream\":false}"
 *
 * 注意：
 *  - OkHttp3 是業界標準的 HTTP 客戶端函式庫
 *  - 程式碼簡潔、效能優異、支援同步與非同步請求
 *  - 適合 Android 開發與企業級應用
 *
 * 適用環境：
 *  - Java 8 或以上版本
 *  - OkHttp3 4.12.0 或以上版本
 *  - 已啟動 Ollama Server，且服務運行於 http://localhost:11434
 */
public class ConsoleTest {
    
    // MediaType 定義 JSON 格式
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    
    public static void main(String[] args) {
        try {
            //---------------------------------------------------------
            // 1. 建立 JSON 請求內容
            //---------------------------------------------------------
            String jsonBody = """
                {
                    "model": "qwen2.5:3b",
                    "prompt": "請用中文介紹 Java 程式語言, 並寫出 HelloWorld 程式",
                    "stream": false
                }
                """;
            
            System.out.println("發送的 JSON:\n" + jsonBody);

            //---------------------------------------------------------
            // 2. 建立 OkHttpClient 實例
            //---------------------------------------------------------
            OkHttpClient client = new OkHttpClient();

            //---------------------------------------------------------
            // 3. 建立 RequestBody（將 JSON 字串包裝成請求主體）
            //---------------------------------------------------------
            RequestBody body = RequestBody.create(jsonBody, JSON);

            //---------------------------------------------------------
            // 4. 建立 Request 物件
            //---------------------------------------------------------
            Request request = new Request.Builder()
                .url("http://localhost:11434/api/generate")
                .post(body)
                .build();

            //---------------------------------------------------------
            // 5. 同步發送請求並取得回應
            //---------------------------------------------------------
            try (Response response = client.newCall(request).execute()) {
                
                // 檢查回應是否成功
                if (!response.isSuccessful()) {
                    System.err.println("請求失敗，HTTP 狀態碼: " + response.code());
                    return;
                }
                
                // 取得回應內容
                String responseBody = response.body().string();
                
                System.out.println("\n回應碼: " + response.code());
                System.out.println("完整回應:\n" + responseBody);

                //---------------------------------------------------------
                // 6. 使用 Gson 解析 JSON 回應
                //---------------------------------------------------------
                String answer = parseResponse(responseBody);
                System.out.println("\n模型回答:\n" + answer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 使用 Gson 解析 JSON 回應
     * 
     * 回應格式範例：
     * {
     *   "model": "qwen:0.5b-chat",
     *   "response": "Java 是一種物件導向的程式語言...",
     *   "done": true
     * }
     */
    private static String parseResponse(String json) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return jsonObject.get("response").getAsString();
        } catch (Exception e) {
            return "解析失敗: " + e.getMessage();
        }
    }
}

