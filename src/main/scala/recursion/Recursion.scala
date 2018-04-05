package recursion

object Recursion extends App{
  val graph = Array(
      Array(0, 0, 0, 0, 0),
      Array(1, 1, 1, 0, 0),
      Array(0, 1, 0, 1, 0),
      Array(1, 0, 1, 0, 0),
      Array(0, 1, 0, 1, 0))
  
  import collection.mutable    
  def reachable(vertex1: Int, vertex2:Int, connect: Array[Array[Int]]): Boolean = {
    def helper(v: Int, visited: mutable.Set[Int]): Boolean = {
      if(v == vertex2) true else{
        visited += v
        var ret = false
        for(v2 <- connect(v).indices; if connect(v)(v2) > 0 && !visited(v2)){
          ret ||= helper(v2, visited)
        }
        ret
      }
    }
    helper(vertex1, mutable.Set())
  }
  println(reachable(2, 4, graph))
  
  
  //for MUD return a list of strings not int
  
   def shortestPath(vertex1: Int, vertex2:Int, connect: Array[Array[Int]]): Int = {
    def helper(v: Int, visited: Set[Int]): Int = {
      if(v == vertex2) 0 else{
        val newVisited = visited + v
        var ret = 1000000000 
        for(v2 <- connect(v).indices; if connect(v)(v2) > 0 && !newVisited(v2)){
          ret = ret min helper(v2, newVisited)
        }
        ret+1
      }
    }
    helper(vertex1, Set())
  }
  println(shortestPath(2, 0, graph))
}