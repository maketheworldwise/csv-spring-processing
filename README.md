<h1 align="center">Welcome to csv-spring-processing 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-0.0.0-blue.svg?cacheSeconds=2592000" />
  <a href="LICENSE" target="_blank">
    <img alt="License: MIT License" src="https://img.shields.io/badge/License-MIT License-yellow.svg" />
  </a>
</p>

> CSV 데이터(이미지명)를 이용하여 S3와 CDN의 URI을 만들고 새로운 CSV 파일에 필드로 넣어 다운받는 개인용 CSV 전처리기 프로젝트입니다. 자세한 내용은 홈페이지를 참고해주세요!

### 🏠 [Homepage](https://velog.io/@maketheworldwise/CSV-%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%97%90-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%B6%94%EA%B0%80%ED%95%B4%EC%A3%BC%EA%B8%B0)

### ✨ [demo]() 👉 홈페이지를 참고해주세요!

## Install

```
JDK 8
```
## Usage

시작 전, **my-settings.yml**에 변환을 적용할 문자열(S3, CDN URI)과 다운받을 경로에 대해 설정해주세요.
(openCSV 읽기, 쓰기용 테스트 파일은 루트 경로에 있습니다.)

```yml
my:
  paths:
    read: "/openCsv 읽기 테스트용 파일.csv"
    write: "/openCsv 쓰기 테스트용 파일.csv"
    download: "다운로드할 경로.csv"

  uris:
    # https://[s3 버킷명].s3.[리전].amazonaws.com/
    s3: "https://s3-image.s3.ap-northeast-2.amazonaws.com/"
    # https://[cdn]/
    cdn: "https://cdn-image/"
```

실행 시 8081 포트를 이용해주세요.

```
http://127.0.0.1:8081
```

## Run tests

```sh
[GET] 127.0.0.1:8081/custom-csv/processing
- RequestParameter : Multipartfile file

[GET] 127.0.0.1:8081/open-csv/processing/test

[GET] 127.0.0.1:8081/open-csv/processing
- RequestParameter : Multipartfile file
```

## Author

👤 **Kevin**

* Website: https://velog.io/@maketheworldwise
* Twitter: []()
* Github: [@maketheworldwise](https://github.com/maketheworldwise)
* LinkedIn: []()

## 🤝 Contributing

이슈와 새로운 기능에 대한 요청은 언제든지 환영합니다!<br />
이슈에 대한 내용은 [이슈 가이드](.github/ISSUE_TEMPLATE.md)를 참고해주세요. 기여 방법에 대한 내용은 [기여 가이드](.github/PULL_REQUEST_TEMPLATE.md)를 참고해주세요.

## Show your support

도움이 되었다면 ⭐️ 을 주세요 :)

## 📝 License

Copyright © 2021 [Kevin](https://github.com/maketheworldwise). <br />
This project is [MIT](LICENSE) licensed.

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
