package fr.licinfo.curve;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.function.Function;

import fr.licinfo.formula.Formula;
import fr.licinfo.formula.Square;
import fr.licinfo.formula.Variable;

public class App {
	public static void main(String[] args) throws IOException {
		Variable variable = new Variable("variable", 0);
		Formula formula = new Square(variable);
		//Function function = new Function(formula, variable);
		Fonction function = new Fonction(formula,variable);
		Curve curve = new Curve(function, -5, 10, 1.0);
		drawCurveWithGnuplot(curve);
	}

	private static void drawCurveWithGnuplot(Curve curve) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		String[] arguments = { "gnuplot", "-persist" };
		Process process = runtime.exec(arguments);
		Writer stream = new OutputStreamWriter(process.getOutputStream());
		writeGnuplotInput(stream, curve);
	}

	private static void writeGnuplotInput(Writer writer, Curve curve) throws IOException {
		writer.write("plot \"-\" with lines\n");
		curve.writePoints(writer);
		writer.write("e\n");
		writer.close();
	}
}
