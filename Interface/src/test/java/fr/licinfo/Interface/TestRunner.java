package fr.licinfo.Interface;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(AllTests.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
