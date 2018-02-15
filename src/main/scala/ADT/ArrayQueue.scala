package ADT

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] extends Queue[A]{
  private var data = new Array[A](10)
  private var front = 0
  private var back = 0
  
  def enqueue(a: A): Unit ={
    if((back +1)%data.length == front){
      
    }
  }
  
  def dequeue(): A = {
    val ret = data(front)
    front = (front + 1) % data.length
    ret
  }
  
  def peek: A = data(front)
  
  def isEmpty: Boolean = front == back
}

