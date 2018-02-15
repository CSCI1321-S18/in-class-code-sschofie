package basics

object Sorts {
  def bubbleSort[A <% Ordered[A]](arr: Array[A]):Unit = {
    for(i <- 0 until arr.length){
      for(j <- 0 until arr.length-1-i){
        if(arr(j) > arr(j+1)){
          val temp = arr(j)
          arr(j)=arr(j+1)
          arr(j+1) = temp
        }
      }
    }
  }
  
  def bubbleSort2[A](arr: Array[A])(gt: (A, A) => Boolean) :Unit = { //gt is a greater than function
    for(i <- 0 until arr.length){
      for(j <- 0 until arr.length-1-i){
        if(gt(arr(j), arr(j+1))){
          val temp = arr(j)
          arr(j)=arr(j+1)
          arr(j+1) = temp
        }
      }
    }
  }
  
  def main(args: Array[String]): Unit = {
    val nums = Array.fill(10)(util.Random.nextInt(100))
    println(nums.mkString(", "))
    bubbleSort(nums)
    println(nums.mkString(", "))
    
    val nums2 = Array.fill(10)(math.random()) 
    //Array is Double so Function must be made POLYMORPHIC to accept all types using <%
    println(nums2.mkString(", "))
    bubbleSort(nums2)
    println(nums2.mkString(", "))
    
    bubbleSort2(nums)(_%10 > _%10)
    
  }
  
}