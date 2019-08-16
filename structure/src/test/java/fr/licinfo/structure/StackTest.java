package fr.licinfo.structure;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testPush() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// assertThat(stack.getVector().get(0);1);
		assertThat(stack.getVector().get(0), equalTo(1));
		assertThat(stack.getVector().get(1), equalTo(2));
		assertThat(stack.getVector().get(2), equalTo(3));

	}

	@Test
	public void testPeek() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);

		assertThat(stack.getVector().capacity(), equalTo(10));
		assertThat(stack.peek(), equalTo(10));

		Stack stack1 = new Stack();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);

		assertThat(stack.getVector().capacity(), equalTo(10));
		assertThat(stack1.peek(), equalTo(5));

		stack1.push(6);
		assertThat(stack.getVector().capacity(), equalTo(10));
		assertThat(stack1.peek(), equalTo(6));

		stack1.push(7);
		assertThat(stack1.peek(), equalTo(7));

	}

	@Test
	public void pop() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		
		
		assertThat(stack.pop(),equalTo(10));
		
	}

	@Test
	public void testSize() {

		Stack stack = new Stack();
		assertThat(stack.size(),equalTo(10));
	}

	@Test
	public void testIsEmpty() {

		Stack stack = new Stack();
		assertThat(stack.isEmpty(),equalTo(true));
		
		stack.push(1);
		assertThat(stack.isEmpty(),equalTo(false));
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertThat(stack.pop(),equalTo(4));
		assertThat(stack.pop(),equalTo(3));
		assertThat(stack.pop(),equalTo(2));
	}
}
