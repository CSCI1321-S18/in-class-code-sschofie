package ADT

import org.junit.Assert._
import org.junit._

class TestMySeq {
  private var lst: MySeq[Int] = null
  
  @Before def init(): Unit = {
    lst = new MutableSLL[Int]()
  }
  
  @Test def startsEmpty():Unit={
    val lst: MySeq[Int] = ???
    assertEquals(0, lst.length)
  }
  
  @Test def add1(): Unit = {
    val lst: MySeq[Int] = ???
    lst.add(0, 7)
    assertEquals (1, lst.length)
    assertEquals (7, lst(0))
  }
}