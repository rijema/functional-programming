if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Breakout'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Breakout'.");
}
var Breakout = function (_, Kotlin) {
  'use strict';
  var throwCCE = Kotlin.throwCCE;
  var ensureNotNull = Kotlin.ensureNotNull;
  var math = Kotlin.kotlin.math;
  var canvas;
  function initializeCanvas$drawBall(closure$ctx, closure$x, closure$y) {
    return function () {
      closure$ctx.beginPath();
      closure$ctx.arc(closure$x.v * 1.0, closure$y.v * 1.0, 10.0, 0.0, math.PI * 2);
      closure$ctx.fillStyle = '#000000';
      closure$ctx.fill();
      closure$ctx.closePath();
    };
  }
  function initializeCanvas$draw(closure$ctx, closure$canvas, closure$drawBall, closure$x, closure$dx, closure$y, closure$dy) {
    return function () {
      closure$ctx.clearRect(0.0, 0.0, closure$canvas.width * 1.0, closure$canvas.height * 1.0);
      closure$drawBall();
      closure$x.v = closure$x.v + closure$dx | 0;
      closure$y.v = closure$y.v + closure$dy | 0;
    };
  }
  function initializeCanvas() {
    var tmp$, tmp$_0;
    var canvas = Kotlin.isType(tmp$ = document.createElement('canvas'), HTMLCanvasElement) ? tmp$ : throwCCE();
    var ctx = Kotlin.isType(tmp$_0 = canvas.getContext('2d'), CanvasRenderingContext2D) ? tmp$_0 : throwCCE();
    ctx.canvas.width = 480;
    ctx.canvas.height = 320;
    ensureNotNull(document.body).appendChild(canvas);
    var x = {v: canvas.width / 2 | 0};
    var y = {v: canvas.height - 30 | 0};
    var dx = 2;
    var dy = -2;
    var drawBall = initializeCanvas$drawBall(ctx, x, y);
    var draw = initializeCanvas$draw(ctx, canvas, drawBall, x, dx, y, dy);
    window.setInterval(draw(), 10);
    return canvas;
  }
  Object.defineProperty(_, 'canvas', {
    get: function () {
      return canvas;
    }
  });
  _.initializeCanvas = initializeCanvas;
  canvas = initializeCanvas();
  Kotlin.defineModule('Breakout', _);
  return _;
}(typeof Breakout === 'undefined' ? {} : Breakout, kotlin);
