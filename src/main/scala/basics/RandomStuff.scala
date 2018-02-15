package basics

object RandomStuff {
  def findAndRemove[A](lst: List[A], isVictim: A => Boolean ): List[A]= {
    //isVictim is a predicate
    lst.find(isVictim) match{
      case Some(victim) => lst.filter(_ != victim)
      case None => lst
    }
  }
  
  def removeFirst[A](lst: List[A], isVictim: A => Boolean): List[A] = {
    lst match{
      case Nil => lst
      case h ::t => 
        if(isVictim(h)) t else h::removeFirst(t, isVictim) //recursion
    }
  }
  
  def removeAll[A](lst: List[A], isVictim: A => Boolean): List[A] = {
    lst match{
      case Nil => lst
      case h ::t => 
        if(isVictim(h)) removeAll(t, isVictim) else h::removeAll(t, isVictim) //recursion
    }
  }
  
  def FindandRemove[A](lst: List[A], isVictim: A => Boolean): (List[A], Option[A]) = {//returns list and found item in a tuple
    lst match{
      case Nil => (lst, None)
      case h ::t => 
        if(isVictim(h)) (t, Some(h)) else{
          val (lst2, victim) = FindandRemove(t, isVictim) //recursion
          (h::lst2, victim)
        }
    }
  }
}