package com.example.musicapplication.utils;

import android.util.Log;

/**
 * @author choosezzz
 * @date 3/28/21 1:10 AM
 */
public class LoggerFactory {

    public static Logger getLogger(String tag) {
        return new Logger(tag);
    }

    public static Logger getLogger(Class clazz) {
        return new Logger(clazz.getSimpleName());
    }
    public static class Logger {
        private String tag;

        public Logger(String tag) {
            this.tag = tag;
        }

        public void info(String message) {
            Log.i(tag, message);
        }

        public void info(String formatter, Object... messages) {
            Log.i(tag, String.format(formatter, messages));
        }
        public void debug(String formatter, Object... messages) {
            Log.d(tag, String.format(formatter, messages));
        }
        public void debug(String message) {
            Log.d(tag, message);
        }

        public void warn(String formatter, Object... messages) {
            Log.w(tag, String.format(formatter, messages));
        }
        public void warn(String message) {
            Log.w(tag, message);
        }

        public void error(String formatter, Object... messages) {
            Log.i(tag, String.format(formatter, messages));
        }
        public void error(String message) {
            Log.e(tag, message);
        }
        public void error(String message, Throwable throwable) {
            Log.e(tag, message, throwable);
        }
    }
}
