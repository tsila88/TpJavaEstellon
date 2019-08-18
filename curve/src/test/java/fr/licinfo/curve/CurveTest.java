package fr.licinfo.curve;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

import fr.licinfo.formula.Variable;

public class CurveTest {
	@Test
	public void test() throws IOException {
		Variable variable = new Variable("variable", 0);
		Function function = new Function(new Sum(variable, variable), variable);
		double startValue = -1;
		double endValue = 1;
		double step = 0.1;
		Curve curve = new Curve(function, startValue, endValue, step);
		Writer writer = new StringWriter();
		curve.writePoints(writer);
		writer.close();

		StringBuilder stringBuilder = new StringBuilder();
		for (double value = startValue; value <= endValue; value += step) {
			stringBuilder.append(value + " " + 2 * value + "\n");
		}

		assertThat(writer.toString(), equalTo(stringBuilder.toString()));
	}

}
