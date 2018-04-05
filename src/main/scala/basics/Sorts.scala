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
  
 // def mergeSort(): ??? = {
 //see book   
 // }
  
 //bad version for sorted input and smaller arrays
  def quickSort[A](lst: List[A])(lt: (A, A) => Boolean): List[A] = lst match{
    case Nil => lst
    case h :: Nil => lst
    case pivot :: t =>
      val (less, greater) = t.partition(x => lt(x, pivot))
      quickSort(less)(lt) ::: (pivot :: quickSort(greater)(lt))
  }
  //good version, see book for better
  def quickSort[A](arr: Array[A])(lt: (A, A) => Boolean): Unit = {
    def helper(start: Int, end: Int): Unit = {
      if(end - start < 10) insertionHelper(arr, start, end) else {
        val pIndex = util.Random.nextInt(end-start)+start
        val temp = arr(start)
        arr(start) = arr(pIndex)
        arr(pIndex) = temp
        var low = start + 1 
        var hight = end -1
      }
    }
    helper(0, arr.length)
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