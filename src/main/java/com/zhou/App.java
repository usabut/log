package com.zhou;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception{
        log4j2Log();
    }
    //slf4j
    //+slf4j-jdk14
    //+slf4j-simple   simplelogger
    //+slf4j-log4j12 + log4j
    //+slf4j-jcl + commons-loggin
    //+logback-classic logback.xml
    public static void slf4jLog() {
        org.slf4j.Logger logger = LoggerFactory.getLogger(App.class);
        logger.debug("debug()...");
        logger.info("info()...");
        logger.error("error()...");
    }

    public static void log4jLog() {
        org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(App.class.getName());
        logger.debug("debug()...");
        logger.info("info()...");
        logger.error("error()...");
    }
    //log4j-api-2.x + log4j-core-2.x    log4j2.properties
    public static void log4j2Log() {
        org.apache.logging.log4j.Logger log = LogManager.getLogger(App.class.getName());
        log.debug("debug()...");
        log.info("info()...");
        log.error("error()...");
    }

    //commons-loggin
    // log4j1.x
    // log4j-api-2.x + log4j-core-2.x + log4j-jcl   log4j2.properties
    public static void commonsLog() {
        Log log = LogFactory.getLog(App.class.getName());
        log.debug("debug()...");
        log.info("info()...");
        log.error("error()...");
    }

    // no dependency    jre/lib/logging.properties
    public static void jdkLog() throws Exception{
        Logger LOGGER = Logger.getLogger(App.class.getName());
        Handler console = new ConsoleHandler();
        Handler file = new FileHandler("jdklog");
        Handler slf4jBridgeHandle = new SLF4JBridgeHandler();
//        console.setLevel(Level.SEVERE);
//        LOGGER.addHandler(console);
        LOGGER.addHandler(file);
        LOGGER.addHandler(slf4jBridgeHandle);
        // LOGGER.setLevel(Level.INFO);
        LOGGER.finest("finest");
        LOGGER.finer("finer");
        LOGGER.fine("fine");
        LOGGER.config("config");
        LOGGER.info("info");
        LOGGER.warning("warning");
        LOGGER.severe("server-");
        System.out.println(LOGGER.getParent().getName());
    }
}
