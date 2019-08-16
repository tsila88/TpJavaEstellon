package fr.licinfo.structure;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class VectorTest {

  @Test
  public void testVectorInt() {
    Vector vector = new Vector(123);
    assertThat(vector.capacity(), equalTo(123));
    assertThat(vector.size(), equalTo(0));
  }

  @Test
  public void testVector() {
    Vector vector = new Vector();
    assertThat(vector.capacity(), equalTo(10));
    assertThat(vector.size(), equalTo(0));
  }

  @Test
  public void testEnsureCapacity_CapacityDoubled() {
    Vector vector = new Vector(23);
    vector.ensureCapacity(24);
    assertThat(vector.capacity(), greaterThanOrEqualTo(23*2));
  }
  
  @Test
  public void testEnsureCapacity_CapacitySatified() {
    Vector vector = new Vector(23);
    vector.ensureCapacity(120);
    /* TODO */
    //fail("not yet implemented");
    assertThat(vector.capacity(), equalTo(120));
  }
  
  @Test
  public void testEnsureCapacity_CapacityAlwaysIncreased() {
    Vector vector = new Vector(120);
    vector.ensureCapacity(10);
    assertThat(vector.capacity(), equalTo(120));
  }

  @Test
  public void testResize() {
    Vector vector = new Vector();
    vector.resize(120);
    /* TODO */
    assertThat(vector.capacity(), equalTo(120));
  }
  
  @Test
  public void testResize_Zeros() {
    Vector vector = new Vector(1);
    vector.add(2);
    vector.resize(0);
    //vector.resize(1);
    assertThat(vector.size(), equalTo(0));
  }

  @Test
  public void testResize_CapacityIncreased() {
    /* TODO */
	  Vector vector = new Vector(1);
	  vector.resize(4);
	  assertThat(vector.capacity(), equalTo(4));
  }
  
  @Test
  public void testResize_CapacityAlwaysIncreased() {
    /* TODO */
	  Vector vector = new Vector(1);
	  vector.resize(2);
	  vector.resize(4);
	  assertThat(vector.capacity(), equalTo(4));
  }

  @Test
  public void testIsEmpty() {
    Vector vector = new Vector();
    assertThat(vector.capacity(), equalTo(10));
    assertThat(vector.isEmpty(), equalTo(true));
    vector.set(0, 2);
    assertThat(vector.isEmpty(), equalTo(false));
  }
  
  @Test
  public void testAdd() {
    Vector vector = new Vector();
    vector.add(10);
    vector.add(11);
    vector.add(12);
    assertThat(vector.get(0), equalTo(10));
    assertThat(vector.get(2), equalTo(12));
    assertThat(vector.get(1), equalTo(11));

    /* TODO */
    //fail("not yet implemented");
  }

  @Test
  public void testSet() {
    Vector vector = new Vector();
    vector.add(10);
    vector.add(11);
    vector.add(12);
    vector.set(0, 2);
    vector.set(2, 4);
    vector.set(1, 123);
    /* TODO */
   // fail("not yet implemented");
    assertThat(vector.get(0), equalTo(2));
    assertThat(vector.get(2), equalTo(4));
    assertThat(vector.get(1), equalTo(123));
  }
  
  
  @Test
  public void testGet() {
    Vector vector = new Vector();
    vector.add(12);
    vector.add(13);
    /* TODO : tester également le fait d'être en dehors des bornes. */
    //fail("not yet implemented");
    assertThat(vector.get(1), equalTo(13));
    assertThat(vector.get(0), equalTo(12));
//    assertNull(vector.get(3));
//    assertThat(vector.get(3), is(nullValue()) );
  }

 
@Test 
  public void testPop() {
	  
	   Vector vector = new Vector();
	    vector.add(1);
	    vector.add(2);
	    vector.add(3);
	    vector.add(4);
	    vector.add(5);
	    vector.add(6);
	    vector.add(7);
	    vector.add(8);
	    vector.add(9);
	    vector.add(10);
	   
	    assertThat(vector.capacity(),equalTo(10));
	    assertThat(vector.get(0), equalTo(1));
	    assertThat(vector.get(1), equalTo(2));
	    assertThat(vector.get(2), equalTo(3));
	    assertThat(vector.get(3), equalTo(4));
	    assertThat(vector.get(4), equalTo(5));
	    assertThat(vector.get(5), equalTo(6));
	    
	    //Depiler le vecteur 
	    
	   // summit = vector.pop();
	   assertThat(vector.pop(), equalTo(10));
	   assertThat(vector.capacity(), equalTo(9));
	 //  assertNotNull(vector.get(0));
	   assertThat(vector.pop(), equalTo(9));
	   assertThat(vector.pop(), equalTo(8));
	   assertThat(vector.pop(), equalTo(7));

	  
	  
  }
  
  
  
}