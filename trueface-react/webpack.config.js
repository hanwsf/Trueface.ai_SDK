var nodeExternals = require('webpack-node-externals');
var webpack = require('webpack');
var browserify = require('browserify');
var path = require('path');
var fs = require('fs');
var os = require('os');
var deleteEmpty = require('delete-empty');
var PACKAGE_FILE = JSON.parse(fs.readFileSync(path.join(__dirname, 'package.json'), 'utf-8'));
var LIB_NAME = PACKAGE_FILE.name;
var TypedocWebpackPlugin = require('typedoc-webpack-plugin');

/* helper function to get into build directory */
var libPath = function (name) {
  if (undefined === name) {
    return 'dist';
  }

  return path.join('dist', name);
}

/* helper to clean leftovers */
var outputCleanup = function (dir) {
  if (false == fs.existsSync(libPath())) {
    return;
  }

  var list = fs.readdirSync(dir);
  for (var i = 0; i < list.length; i++) {
    var filename = path.join(dir, list[i]);
    var stat = fs.statSync(filename);

    if (filename == '.' || filename == '..') {
      // pass these files
    } else if (stat.isDirectory()) {
      // outputCleanup recursively
      outputCleanup(filename, false);
    } else {
      // rm fiilename
      fs.unlinkSync(filename);
    }
  }
  fs.rmdirSync(dir);
};

/* precentage handler is used to hook build start and ending */
var percentage_handler = function handler(percentage, msg) {
  if (0 === percentage) {
    /* Build Started */
    outputCleanup(libPath());
    console.log('Build started... Good luck!');
  } else if (1.0 === percentage) {
    // TODO: No Error detection. :(
    create_browser_version(webpack_opts.output.filename);
  }
}

var webpack_opts = {
  entry: './src/index.tsx',
  target: 'node',
  output: {
    filename: libPath('index.js'),
    libraryTarget: 'commonjs2'
  },
  resolve: {
    extensions: ['.ts', '.tsx', '.js'],
    modules: [
      'node_modules',
      'src',
    ]
  },
  module: {
    loaders: [
      { test: /\.css$/, loader: "style-loader!css-loader" },
      {
        enforce: 'pre',
        test: /\.ts$/,
        loader: 'tslint-loader',
        exclude: /node_modules/,
      }, {
        test: /\.ts$/,
        loader: 'ts-loader',
        exclude: [
          /node_modules/
        ],
      },
      {
        enforce: 'pre',
        test: /\.tsx$/,
        loader: 'tslint-loader',
        exclude: /node_modules/,
      }, {
        test: /\.tsx$/,
        loader: 'ts-loader',
        exclude: [
          /node_modules/
        ],
      },
    ],
  },
  externals: [nodeExternals()],
  plugins: [
    new webpack.optimize.UglifyJsPlugin(),
    new webpack.LoaderOptionsPlugin({
      options: {
        tslint: {
          emitErrors: true,
          failOnHint: true
        }
      }
    }),
    new webpack.ProgressPlugin(percentage_handler),
    new TypedocWebpackPlugin({
      "jsx": "react"
    }, './src')
  ],
}

var create_browser_version = function (inputJs) {
  let outputName = inputJs.replace(/\.[^/.]+$/, '');
  outputName = `${outputName}.browser.js`;
  console.log('Creating browser version ...');

  let b = browserify(inputJs, {
    standalone: LIB_NAME,
  });

  b.bundle(function (err, src) {
    if (err != null) {
      console.error('Browserify error:');
      console.error(err);
    }
  }).pipe(fs.createWriteStream(outputName));
}

module.exports = webpack_opts;
