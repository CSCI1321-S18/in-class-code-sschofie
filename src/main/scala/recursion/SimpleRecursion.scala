package recursion

object SimpleRecursion extends App{
  
  def factorial(n:Int):Int= {
    if(n>1){
      n*factorial(n-1)
    }else
      return n
    }
  
  def fibonacci(n:Int): Int = {
    if(n <= 2) 1
    else{
      fibonacci(n-2) + fibonacci(n-1)
    }
  }
  //not completely efficient, not beyond 50
  
}