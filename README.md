<h1 align="center">Welcome to csv-spring-processing ð</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-0.0.0-blue.svg?cacheSeconds=2592000" />
  <a href="LICENSE" target="_blank">
    <img alt="License: MIT License" src="https://img.shields.io/badge/License-MIT License-yellow.svg" />
  </a>
</p>

> CSV ë°ì´í°(ì´ë¯¸ì§ëª)ë¥¼ ì´ì©íì¬ S3ì CDNì URIì ë§ë¤ê³  ìë¡ì´ CSV íì¼ì íëë¡ ë£ì´ ë¤ì´ë°ë ê°ì¸ì© CSV ì ì²ë¦¬ê¸° íë¡ì í¸ìëë¤. ìì¸í ë´ì©ì ííì´ì§ë¥¼ ì°¸ê³ í´ì£¼ì¸ì!

### ð  [Homepage](https://velog.io/@maketheworldwise/CSV-%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%97%90-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%B6%94%EA%B0%80%ED%95%B4%EC%A3%BC%EA%B8%B0)

### â¨ [demo]() ð ííì´ì§ë¥¼ ì°¸ê³ í´ì£¼ì¸ì!

## Install

```
JDK 8
```
## Usage

ìì ì , **my-settings.yml**ì ë³íì ì ì©í  ë¬¸ìì´(S3, CDN URI)ê³¼ ë¤ì´ë°ì ê²½ë¡ì ëí´ ì¤ì í´ì£¼ì¸ì.
(openCSV ì½ê¸°, ì°ê¸°ì© íì¤í¸ íì¼ì ë£¨í¸ ê²½ë¡ì ììµëë¤.)

```yml
my:
  paths:
    read: "/openCsv ì½ê¸° íì¤í¸ì© íì¼.csv"
    write: "/openCsv ì°ê¸° íì¤í¸ì© íì¼.csv"
    download: "ë¤ì´ë¡ëí  ê²½ë¡.csv"

  uris:
    # https://[s3 ë²í·ëª].s3.[ë¦¬ì ].amazonaws.com/
    s3: "https://s3-image.s3.ap-northeast-2.amazonaws.com/"
    # https://[cdn]/
    cdn: "https://cdn-image/"
```

ì¤í ì 8081 í¬í¸ë¥¼ ì´ì©í´ì£¼ì¸ì.

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

ð¤ **Kevin**

* Website: https://velog.io/@maketheworldwise
* Twitter: []()
* Github: [@maketheworldwise](https://github.com/maketheworldwise)
* LinkedIn: []()

## ð¤ Contributing

ì´ìì ìë¡ì´ ê¸°ë¥ì ëí ìì²­ì ì¸ì ë ì§ íìí©ëë¤!<br />
ì´ìì ëí ë´ì©ì [ì´ì ê°ì´ë](.github/ISSUE_TEMPLATE.md)ë¥¼ ì°¸ê³ í´ì£¼ì¸ì. ê¸°ì¬ ë°©ë²ì ëí ë´ì©ì [ê¸°ì¬ ê°ì´ë](.github/PULL_REQUEST_TEMPLATE.md)ë¥¼ ì°¸ê³ í´ì£¼ì¸ì.

## Show your support

ëìì´ ëìë¤ë©´ â­ï¸ ì ì£¼ì¸ì :)

## ð License

Copyright Â© 2021 [Kevin](https://github.com/maketheworldwise). <br />
This project is [MIT](LICENSE) licensed.

***
_This README was generated with â¤ï¸ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
