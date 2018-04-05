package recursion

object BinPacking extends App{
  def packBins(items: Array[Int], bins: Array[Int]): Boolean = {
    def helper(i: Int): Boolean = {
      if(i >= items.length) true
      else {
        var ret = false
        for(j <- bins.indices) { //indices same as until bins.length
          if(items(i) <= bins(j)){
            bins(j) -= items(i)
            ret ||= helper(i+1) //ret or equals helper
            bins(j) += items(i)
          }
        }
        ret
      }
    }
    helper(0)
  }
  
  println(packBins(Array(3, 3, 4), Array(5, 7)))
}