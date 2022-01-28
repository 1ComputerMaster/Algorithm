---
title:  "Modern JavaScript 이해의 시작"
categories: web
tags: frontend javascript
---

- [Modern JavaScript 이해의 시작](#modern-javascript-이해의-시작)
  * [Old Style](#Old-style)
    + [간단한 예시](#간단한-예시)
    + [react.js를 참조 하기](#reactjs를-참조-하기)
  * [패키지 매니저](#패키지-매니저)
    + [NPM](#npm)
    + [npm으로 받은 react 사용해보기](#npm으로-받은-react-사용해보기)
  * [모듈 번들러](#모듈-번들러)
    + [node.js](#nodejs)
    + [Webpack](#webpack)
    + [Webpack config](#webpack-config)
  * [트랜스파일러](#트랜스파일러)
    + [Babel](#babel)
  * [태스크러너](#태스크러너)
    + [webpack-dev-server](#webpack-dev-server)
  * [마무리하며](#마무리하며)
    + [지금까지 한 것](#지금까지-한-것)
    + [결론](#결론)
    + [참조](#참조)

#  Modern JavaScript 이해의 시작

JavaScript알못의 입장에서 자바스크립트를 공부하기에는 벽이 높다는 것을 알았다. 그래서 현재의 자바스크립트를 조금이라도 더 잘 이해하기 위해 본격 몸부림 시작글이다.

- JS를 모던하게 진화시킨 모든 복잡한 히스토리는 바로 2008년 구글의 V8엔진 공개를 계기로 시작됨
- 이를 통해 브라우져뿐 아니라 서버에서도 실행가능한 풀스택 언어로써 가장 많이 쓰이고 인기있는 언어가 됨


## Old Style

아주 원시적인 JavaScript의 모듈 시스템, 브라우져에서 HTML을 처리할때 JavaScript 소스모듈들도 함께 비동기적으로 사용하는 방식
- 문제점: 여러 JS를 처리할때 이전에 선언된 동일한 전역변수가 재정의 됨(모듈간 스코프가 없어서 서로 오염시킴)

### 간단한 예시

```html
<!--index.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modern JavaScript</title>
</head>
<body>
    <div id="app">
      <h1></h1>
    </div>
    <script src="ssafy.js"></script>
    <script src="index.js"></script>
    <script>
        console.log({user_id});
    </script>  
</body>
</html>
```

```js
// ssafy.js
var user_id = 'ssafy';
```

```js
// index.js
var user_id = 'index';
document.querySelector('h1').innerText = 'Hello, world!'
```

### react.js를 참조 하기

전통적인 방식이라면 [react.js](https://ko.reactjs.org/docs/add-react-to-a-website.html) CDN 주소를 소스 프로젝트에 추가 한다. 

```html
<!--index.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modern JavaScript</title>
</head>
<body>
    <div id="app">
    </div>
    <script src="https://unpkg.com/react@17/umd/react.production.min.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@17/umd/react-dom.production.min.js" crossorigin></script>
    <script src="index.js"></script>
</body>
</html>
```

```js
// index.js
class Hello extends React.Component {
    render() {
        return React.createElement('h1', null, `Hello, ${this.props.message}`);
    }
}

ReactDOM.render(
    React.createElement(Hello, {message: 'react!'}, null),
    document.getElementById('app')
);
```


## 패키지 매니저

자바스크립트에서도 `node.js`의 Package Manager를 도입해서 원하는 버전의 모듈을 이용해 보자.

1. [Bower(2013)](https://bower.io/)
2. [Npm(2015)](https://www.npmjs.com/)
3. [Yarn(2016)](https://yarnpkg.com/en/)

현재 `yarn`도 많이 사용되지만 `npm`을 기준으로 이야기 해보면 npm은 `node.js` 를 위해 특별히 만들어진 패키지 매니저이다.  
node.js는 프론트엔드가 아닌 서버 위에서 구동되도록 설계된 자바스크립트 실행 환경이다.

### NPM

> NPM의 성장과 함께 JavaScript 생태계의 규모는 폭발적으로 증가

```shell
$ npm init
```

npm을 사용하기 위해서 init을 해주면 `package.json`이 생성된다.

```json
{
  "name": "modern-js",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC"
}
```

react를 설치하기 위해 아래의 명령을 해준다.

```shell
$ npm install react react-dom
```

이 작업은 2가지 일을 수행한다.
1. `node_modules` 라는 폴더에 react.js, react-dom.js 패키지 저장
2. `package.json`에서 `dependencies`에 react, react-dom 패키지 추가

```json
{
  "name": "modern-js",
  ...,
  "dependencies": {
    "react": "^17.0.2",
    "react-dom": "^17.0.2"
  }
}
```

`package.json`에는 이렇게 필요한 패키지의 내역과 버전이 명시되어 있기 때문에 `node_modules` 폴더를 주고 받기 보다는 이런 내역 파일만 있으면 `install` 명령어로 모두 down받을 수 있다.

```shell
$ npm install
```

### npm으로 받은 react 사용해보기

`node_modules`에 react가 받아졌다면 아래와 같은 디렉토리 구조에 들어있다.
```
./node_modules/react/umd/react.production.min.js
./node_modules/react-dom/umd/react-dom.production.min.js
```

그래서 위의 `index.html`에서 `react*.production.min.js` 위치를 변경해준다.

```html
    <script src="./node_modules/react/umd/react.production.min.js"></script>
    <script src="./node_modules/react-dom/umd/react-dom.production.min.js"></script>
    <script src="index.js"></script>
```

이제 CDN 파일을 수동으로 다운받아서 참조하는 것보다는 많이 좋아졌다. 그런데 매번 `node_modules` 를 깊게 뒤져야 하는 것은 여전히 불편하다.


## 모듈 번들러

### node.js

* 자바스크립트는 오직 브라우저 환경에서만 구동되는데
* 보안상의 이유로 브라우저에서는 파일시스템에 접근할 수 없기 때문이다.
* 자바스크립트에서는 실행 중 다른 코드를 불러들일 수 없다. 

따라서 초기에 HTML로 모두 로드 하여 전역적으로 사용한다. 위의 예에서 React는 전역 변수가 된다.  
자바스크립트에서는 이런 브라우저 외의 생태계를 만들기 시작하였고 `CommonJS(2009)` 프로젝트가 시작되었다.  
전역변수에 할당하는 방법 대신 exports, require 와 같은 직관적이고 간단한 문법을 사용한 CommonJS 모듈 시스템 방식을 선택한 구현체가 바로 `node.js`이다.

```js
// CommonJS

// 모듈 정의
module.exports = foo;

// 모듈 사용
const foo = require("./foo");
```

> node.js는 브라우저가 아닌 서버환경에서 구동되도록 설계된 자바스크립트 환경이다.

이제 HTML에서 script tag로 로딩하지 않고 새로운 모듈 로딩 방식으로 바꿔 보자.

```js
// index.js
React = require('react');
ReactDOM = require('react-dom');

class Hello extends React.Component {
    ...
```

`node.js`는 외부에서 받아온 패키지들이 `node_modules`내에 있다는 것을 알고 있기에 굳이 full path를 입력하지 않아도 되므로 index.html에서 `<script>node_modules/...`는 제거한다.

그 대신 `require`만 있으면 된다. 하지만 아직 끝이 아니다.

require로 어떻게든 브라우져에서도 동작하게 하고 싶다. 이런 이유로 모듈 번들러가 등장한다.

- 브라우저에서는 필요한 모듈들을 네트워크를 통해 비동기적으로 다운로드 받고 나서야 사용이 가능
- 비동기 로드 및 브라우저를 지원하지 않는 CommonJS의 설계로 인해 'require is not defined' 에러 발생
- 모듈 로더는 JavaScript 모듈을 런타임에 로드할 수 있게 만드는 구현체임
- 만약 node.js로 위코드를 실행하면 정상적으로 모듈로딩이 가능하나 브라우져 모듈 로더로는 동작시킬 수 없음

### webpack

자바스크립트 모듈 번들러는 파일 시스템에 접근 할 수 있는 빌드 단계에서 위와 같은 문제를 해결하여 브라우저와 호환되는 (파일 시스템에 액세스 할 필요가 없는) 최종 결과물을 만들어내는 빌드도구

* 원조: [Browserify(2011)](http://browserify.org/)
* [webpack(2015)](https://webpack.github.io/)

`webpack`을 사용하여 `require('react')`가 브라우저에서 동작하도록 해보자. webpack도 npm 패키지이다.

```shell
$ npm install webpack webpack-cli@3.3.12 --save-dev
```

```json
{
  "name": "modern-js",
  ...,
  "devDependencies": {
    "webpack": "^5.67.0",
    "webpack-cli": "^3.3.12"
  }
}
```

webpack을 설치하고 나면 `node_modules`에 `.bin` 디렉토리에서 `webpack` 명령어를 사용할 수 있게 된다.

```shell
$ ./node_modules/.bin/webpack ./index.js --mode=development
```
윈도우즈에서는
```cmd
.\node_modules\.bin\webpack ./index.js --mode=development
```

이것은 `index.js`의 내용을 읽어 `require('react')`등의 내용을 전부 적절하게(?) 변환하여 `dist/main.js`로 담아두는 작업을 한다. 따라서 HTML에서는 이제 `dist/main.js`를 사용하여야 한다.

```html
<!--index.html-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modern JavaScript</title>
</head>
<body>
    <div id="app">
      <h1></h1>
    </div>
    <script src="dist/main.js"></script>
</body>
</html>
```

이제 브라우저에서 `index.html`을 열어보면 Hello, react!가 문제없이 출력된 것을 확인 할 수 있다.

### webpack config

이제 또 다른 고민을 해봐야 한다.
> 만약, index.js가 수정된다면?

정답은 webpack으로 새로 변환해 줘야한다. 그리고 이렇게 매번 변할 때 마다 파라미터도 변경될 수 있는데 config내에 모든 내용을 입력해 둘 수 있다.

```js
// webpack.config.js
module.exports = {
    mode: 'development',
    entry: './index.js',
    output: {
        filename: 'main.js',
        publicPath: 'dist'
    }
};
```

이제 webpack실행은 명령어만 실행해주면 된다.
```shell
$ ./node_modules/.bin/webpack
```
윈도우즈에서는
```cmd
.\node_modules\.bin\webpack
```

그런데 점점 이해하는 것은 늘었지만 왜이리 고달픈지? 아직 알아야 할 것이 끝이 아니다.


## 트랜스파일러

이 외에도 필요에 의해 다른 코드로 변환해주는 것들이 있다.

* [Babel](https://babeljs.io/) - 최신 JavaScript를 브라우저 호환이 높은 버전(ES5)로 변환
* [CoffeeScript(2010)](http://coffeescript.org/) - 임의의 괄호, 의미있는 공백등을 적용함으로써 자바스크립트를 발전시는데 초점
* [TypeScript](http://www.typescriptlang.org/) - 정적 형지정(typing)을 추가
>컴파일은 일반적으로 소스 코드를 바이트 코드로 변환하는 작업을 의미한다. TypeScript 컴파일러는 TypeScript 파일을 자바스크립트 파일로 변환하므로 컴파일보다는 트랜스파일링(Transpiling)이 보다 적절한 표현이다.

### Babel

babel 설치도 npm으로 할 수 있다.
```shell
$ npm install @babel/core @babel/preset-env babel-loader --save-dev
```

* `babel/core` - babel의 핵심부
* `babel/preset-env` - 어떠한 자바스크립트 새 기능을 트랜스파일할지에 대한 사전정의(preset)
* `babel-loader` -  babel이 webpack과 함께 일 할수 있게 해주는 패키지

이제 `webpack.config.js`를 아래와 같이 수정하여 `babel-loader`를 사용할 수 있게 한다.

```js
// webpack.config.js
module.exports = {
    mode: 'development',
    entry: './index.js',
    output: {
        filename: 'main.js',
        publicPath: 'dist'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader'
                }
            }
        ]
    }
};
```


이제 [ES2015(ES6) template string](https://babeljs.io/docs/en/learn/#template-strings)를 아래처럼 `index.js`에 사용할 수 있다.
또한 [ES2015(ES6) import](https://babeljs.io/docs/en/learn/#modules)도 사용해 볼수 있다.

```js
// index.js
import React from 'react'
import ReactDOM from 'react-dom'

class Hello extends React.Component {
    render() {
        return React.createElement('h1', null, `Hello, ${this.props.message} by webpack and babel`);
    }
}
...
```

webpack을 다시 구동해준 다음 `index.html`을 refresh해주면 된다.
현재는 `IE9` 같은 구식 브라우저가 없기 때문에 정확한 테스트는 못해보지만 ........... 된걸로 믿고....


## 태스크러너

자바 스크립트를 빌드하기 위해서는 커맨드라인상에서 할 일들이 꽤 많다. 이를 축약하여 좀더 쉽게 수행할 수 있게 task로 등록할 수 있다.  
개발 과정에서 코드를 작성하고, 컨벤션을 유지하기 위해 린트를 사용하며, Sass나 TypeScript처럼 전처리가 필요한 언어를 컴파일하고,  
소스 코드를 축소(minify)하고 하나의 파일로 묶는(bundle) 일련의 작업들이 필요하고 이를 자동화 할 수 있는 도구

* Grunt(2013)
* Gulp
* npm

npm 스크립트에서 `webpack` 사용을 좀 더 쉽게 만들어 보자.
기존 `package.json`파일에서 `scripts`내용에 `build` 스크립트를 추가하였다.
* `--progress` - 진행 정도를 백분율로 보여준다.

```json
{
  "name": "modern-js",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "build": "webpack --progress --mode production",
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  ...
}
```

이제 `npm run` 명령어로 이것을 실행해 보자.
 둘 모두  webpack을 실행하는 명령이며 watch는 알아서 자바스크립트코드가 바뀔때마다 알아서 webpack 수행을 해준다.
 심지어 node.js는 node_modules 디렉토리 위치를 알고 있기에 webpack 경로를 지정하지 않아도 된다.

```shell
$ npm run build
```

### webpack-dev-server

`webpack-dev-server`도 써보자. 단순한 웹서버를 제공해주어 개발단계에서 확인하기에 좋은 도구이다.

```shell
$ npm i -D webpack-dev-server@3.11.2
```

기존 `package.json`파일에서 `scripts`내용에 `start` 스크립트를 추가하였고
동작확인을 위해 `index.js`파일에서 문구를 변경하였다.

```json
...
 "scripts": {
    "start": "webpack-dev-server --open",
    ...
  },
...
```
```js
// index.js
...
return React.createElement('h1', null, `Hello, ${this.props.message} by webpack and babel on webpack-dev-server`);
...
```

```shell
$ npm start
```

이제 `index.html`을 브라우저에서 직접 호출하지 말고 `localhost:8080`으로 보면 자동으로 열릴 것이면 `index.js`를 수정하면 `webpack-dev-server`가 다시 빌드하여 브라우저를 자동으로 새로고침 할 것이다.

지금 사용중인 개발환경(package.json)과 비교해 보세요.
<details><summary>최종 package.json</summary>

```json
{
  "name": "modern-js",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "start": "webpack-dev-server --open",
    "build": "webpack --progress --mode production",
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "dependencies": {
    "react": "^17.0.2",
    "react-dom": "^17.0.2"
  },
  "devDependencies": {
    "@babel/core": "^7.16.12",
    "@babel/preset-env": "^7.16.11",
    "babel-loader": "^8.2.3",
    "webpack": "^5.67.0",
    "webpack-cli": "^3.3.12",
    "webpack-dev-server": "^3.11.2"
  }
}
```
</details>

<details><summary>React: npx create-react-app hello-react</summary>

```json
{
  "name": "hello-react",
  "version": "0.1.0",
  "private": true,
  "dependencies": {
    ...
    "react": "^17.0.2",
    "react-dom": "^17.0.2",
    "react-scripts": "5.0.0",
    "web-vitals": "^2.1.4"
  },
  "scripts": {
    "start": "react-scripts start",
    "build": "react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject"
  },
...
```
</details>

<details><summary>Vue: vue create hello-vue</summary>

```json
{
  "name": "hello-vue",
  "version": "0.1.0",
  "private": true,
  "scripts": {
    "serve": "vue-cli-service serve",
    "build": "vue-cli-service build",
    "lint": "vue-cli-service lint"
  },
  "dependencies": {
    "core-js": "^3.6.5",
    "vue": "^3.0.0"
  },
  "devDependencies": {
    "@vue/cli-plugin-babel": "~4.5.0",
    "@vue/cli-plugin-eslint": "~4.5.0",
    "@vue/cli-service": "~4.5.0",
    "@vue/compiler-sfc": "^3.0.0",
    "babel-eslint": "^10.1.0",
    "eslint": "^6.7.2",
    "eslint-plugin-vue": "^7.0.0"
  },
...
```
</details>


## 마무리하며

### 지금까지 한 것

* 단순한 HTML과 js 모듈시스템으로 시작
* 패키지 매니저(node.js)를 사용하여 3rd party 모듈 자동 다운로드
* 모듈 번들러를 사용하여 브라우저를 위한 단일 스크립트 파일로 변환
* 트랜스파일러를 사용하여 Superset(상위확장) 언어를 변환 또는 새로운 JS표준문법(ES6)이 구버전 브라우져에서 동작하도록 변환
* 태스크러너(npm scripts)를 사용하여 각기 다른 부분의 빌드 프로세스를 자동화

### 결론

지금까지 Modern JavaScript 이해에 대한 시작을 한거 같다. 이제 그동안 이쪽 생태계에서 어떠한 노력들을 해서 어떠한 식으로 발전되어 갔는지 이해가 조금 된거 같다.

### 참조

이 글의 오리지널은 [구닥다리 공룡을 위한 오늘날의 JavaScript](https://steemit.com/javascript/@march23hare/javascript), [👑JavaScript 번들러로 본 조선시대 붕당의 이해](https://wormwlrm.github.io/2020/08/12/History-of-JavaScript-Modules-and-Bundlers.html) 를 참고 하면서 재해석한 글입니다.
* 모던 JavaScript 튜토리얼 : https://ko.javascript.info/
* 모던 자바스크립트 딥다이브 : http://www.yes24.com/Product/Goods/92742567
