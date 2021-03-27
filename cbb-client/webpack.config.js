const webpack = require("webpack");
path = require("path");
(CopyWebpackPlugin = require("copy-webpack-plugin")),
  (HtmlWebpackPlugin = require("html-webpack-plugin")),
  (MiniCssExtractPlugin = require("mini-css-extract-plugin"));

const isProd = process.env.NODE_ENV === "production";

const config = {
  entry: path.resolve(__dirname, "src/index.tsx"),
  output: {
    path: path.resolve(__dirname, "build"),
    filename: "bundle.[hash].js",
    publicPath: "/"
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        loader: "babel-loader?cacheDirectory",
        exclude: [/node_modules/]
      },
      {
        test: /\.(ts|tsx)?$/,
        loader: "ts-loader",
        exclude: [/node_modules/]
      },
      {
        test: /\.html$/,
        use: [
          {
            loader: "html-loader",
            options: { minimize: true }
          }
        ]
      }
    ]
  },
  resolve: {
    extensions: [".js", ".jsx", ".ts", ".tsx"]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: path.resolve(__dirname, "src/index.html"),
      filename: "./index.html"
    }),
    new CopyWebpackPlugin([
      { from: "src/img", to: "img" },
      // { from: "src/error.html", to: "" },
      { from: "src/lib/fonts", to: "fonts" },
      { from: "src/lib/webfonts", to: "webfonts" },
      {
        from: "src/lib/font-awesome-v5.10.2.min.css",
        to: "lib/font-awesome-v5.10.2.min.css"
      }
    ])
  ]
};

config.node = {
  fs: "empty",
  net: "empty",
  tls: "empty"
};

if (isProd) {
  config.module.rules.push({
    test: /\.(sa|sc|c)ss$/,
    use: [MiniCssExtractPlugin.loader, "css-loader", "sass-loader"]
  });

  config.plugins.push(
    new MiniCssExtractPlugin({
      filename: "index.[hash].css",
      chunkFilename: "[id].[hash].css"
    })
  );
} else {
  config.module.rules.push({
    test: /\.(sa|sc|c)ss$/,
    use: ["style-loader", "css-loader", "sass-loader"]
  });

  config.devServer = {
    port: 8081,
    contentBase: path.resolve(__dirname, "build"),
    disableHostCheck: true,
    historyApiFallback: true,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        secure: false
      }
    }
  };
}

module.exports = config;
