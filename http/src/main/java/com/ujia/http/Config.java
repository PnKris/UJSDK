package com.ujia.http;

public class Config {
    public int writeTimeout = 10;
    public int readTimeout = 10;
    public int connTimeout = 10;



    public static class Builder {
        private int writeTimeout = 10;
        private int readTimeout = 10;
        private int connTimeout = 10;

        public int getWriteTimeout() {
            return writeTimeout;
        }

        public Builder setWriteTimeout(int writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }

        public Builder setReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder setConnTimeout(int connTimeout) {
            this.connTimeout = connTimeout;
            return this;
        }

        public Config build() {
            return new Config();
        }
    }
}
