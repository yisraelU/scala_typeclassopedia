package mtl

import org.scalatest.{FunSpec, MustMatchers}

/**
  * Generate all permutations of the list using filterM
  *
  * MonadFilter filterM moved to TraverseFilter filterA: https://github.com/typelevel/cats/blob/master/CHANGES.md
  *
  * Explanations:
  *   http://stackoverflow.com/questions/28872396/haskells-filterm-with-filterm-x-true-false-1-2-3
  *   (Brent Yorgey in Haskell) https://byorgey.wordpress.com/2007/06/26/deducing-code-from-types-filterm/
  */
class TraverseEmptyListPermutationsSpec
  extends FunSpec
  with MustMatchers {

  describe("filterA") {
    it("compute all permutations of the lit if given List(true, false)") {
      import cats.mtl.syntax.empty._
      import cats.mtl.instances.empty.listTraverseEmpty
      import cats.implicits.catsStdInstancesForList

      val allPermutations = List(
        List(1, 2, 3),
        List(1, 2),
        List(1, 3),
        List(2, 3),
        List(1),
        List(2),
        List(3),
        Nil
      )
      List(1, 2, 3).filterA(_ => List(true, false)) contains theSameElementsAs(allPermutations)
    }
  }
}