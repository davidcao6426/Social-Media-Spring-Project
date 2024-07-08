# 專案說明
本專案為使用 Spring Boot 與 Vue 前後端分離練習作品。  
本專案為後端專案，前端專案存放於 https://github.com/davidcao6426/Social-Media-Vue-Project.git
專案參考自社群網頁軟體，實現登入、註冊、發文、回覆等功能。

# 已實作功能
## BackEnd
User
* 註冊
* 登入驗證(密碼使用 salt&hash 加密)
* 修改使用者
* 刪除使用者

Post
* 新增文章
* 刪除文章
* 修改文章
* 取得所有文章

Comment
* 新增留言

## FrontEnd
* 各頁面*View.vue建置完成
* 登入功能
* 註冊功能
* 文章發布功能
* 列出所有文章及發佈者
* 文章留言功能

# BackEnd 資料夾結構
## main
* [controller](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/controller): 處理 FrontEnd 需求，為 api server 對外連接的介面。
* [entity](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/entity): 存放封裝來自Database資料的相關物件。
* [repository](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/respository): 處理後端與Database互動的相關操作。
* [service](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/service): 處理業務邏輯。
* [config](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/config): 存放server設定相關物件，包含cors設定、security設定等。
* [util](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/util): 存放公用函式庫，包含加密等。
* [db](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/db): 存放資料庫相關的文件，包含DDL、DML、DQL等，在[資料庫建置](#資料庫建置)有更詳細的說明。

## test
現僅針對各物件做單元測試，整合測試尚未實現。
* [controllerTest](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/test/java/com/example/servingwebcontent/controller): 使用 mockMvc 與 MockBean，用以確認 controller 能正確回傳。
* [repositoryTest](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/test/java/com/example/servingwebcontent/respository):  透過定義於 repository 中的預存程式(stored procedure) 進行資料庫操作，確保預存程式在各項測試情境的預期輸出與實際輸出一致。
* [serviceTest](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/test/java/com/example/servingwebcontent/service): 使用 MockBean，對 service 進行各項例外情境測試與正確性驗證，確保功能正常。

# 版本資訊
## BackEnd
* Eclipse Temurin 17.0.11
* Spring Boot 3.2.5
* MySql 8.3.0
* Junit 4.13.2

## FrontEnd
* Vue 3.4.21

# 執行說明
## BackEnd
* clone https://github.com/davidcao6426/Social-Media-Spring-Project.git
* cd ./Social-Media-Spring-Project
* ./mvnw spring-boot:run

## BackEnd Test
* cd ./Social-Media-Spring-Project
* ./mvnw test

## FrontEnd
* clone https://github.com/davidcao6426/Social-Media-Vue-Project.git
* cd ./Social-Media-Vue-Project/
* npm install
* npm run dev
* 網站入口: http://localhost:5173/login

# 資料庫建置
* 資料庫使用之資料定義語言(Data Definition Language，DDL)存放於 [src/main/java/com/example/servingwebcontent/db/ddl](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/db/ddl) 。  
* 本專案使用 stored procedure 作為操作資料庫的媒介，所使用之資料查詢語言(Data Query Language，DQL)與資料操作語言(Data Manipulation Language，DML)，
存放於 [src/main/java/com/example/servingwebcontent/db/](https://github.com/davidcao6426/Social-Media-Spring-Project/tree/main/src/main/java/com/example/servingwebcontent/db) 中的dql與dml資料夾。  
