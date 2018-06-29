package com.hybris.hybris123.runtime.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VersionHelper {
	private static final Logger LOG = LoggerFactory.getLogger(VersionHelper.class);
	
	public static String version=null;
	
	public static boolean is67() {
		return version.startsWith("6.7");
	}
	public static boolean is66() {
		return version.startsWith("6.6");
	}
	public static boolean is65() {
		return version.startsWith("6.5");
	}
	public static boolean is64() {
		return version.startsWith("6.4");
	}
	public static boolean is63() {
		return version.startsWith("6.2");
	}
	public static boolean is62() {
		return version.startsWith("6.2");
	}
	public static boolean is61() {
		return version.startsWith("6.1");
	}
	public static boolean is60() {
		return version.startsWith("6.0");
	}
	
	public static String getVersion() {
		if(version!=null)
			return version;
		
		String buildNumberPath = "./../hybris/bin/platform/build.number";		
		Stream<String> stream;
		try {
			stream = Files.lines(Paths.get(buildNumberPath));
			version = stream.filter(s->s.contains("version=")).findFirst().get().split("=")[1];
		} catch (IOException e) {
			LOG.error("Version not found");
		}
		return version;
	}

}

