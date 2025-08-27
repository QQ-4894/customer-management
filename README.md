# 顧客管理システム
企業向けの顧客管理システム。
<br>
<br>

## 作成目的
- 企業の業務効率化。
    - 社内の全員が、顧客情報をリアルタイムで共有・管理できるWebシステムを構築。
<br>

## 想定ユーザー
企業内の営業・事務・技術部門など、顧客情報を扱う全ての社員。
<br>
<br>

## 主な機能
- ダッシュボード
- 顧客の一覧表示・登録・編集・削除
- お問い合わせ履歴の管理
- 訪問履歴の管理
- 自社ユーザーの詳細
<br>

## 使用技術
- 設計：dbdiagram.io（ER図）、Figma（UI設計）
- フロントエンド：HTML / CSS / JavaScript
- バックエンド：Java / Spring Boot
- ビルド：Maven
- データベース：H2 Database
<br>

## セットアップ方法
```bash
git clone https://github.com/yourname/customer-management.git
cd customer-management
./mvnw spring-boot:run
```
<br>

## 工夫した点
- Spring Bootによる、下記メリットを利用。
    - Spring Initializrで、H2 Database / JUnit / JPA などのライブラリを自動追加。
    - Controller / Service / Repository / DTO / Entity とフォルダを分離し、責務を明確化。
- RESTful API設計（GET / POST / PUT / DELETE）により、動作を直感的に理解。
- CRUD操作 （登録 / 表示 / 編集 / 削除）により、理解しやすい設計。
- H2 Databaseによる、ローカル環境での動作確認を簡易化。
- JUnitによる、容易な検証。