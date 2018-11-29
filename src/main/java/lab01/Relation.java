package lab01;

import lab02.FactorizationClass;

import java.util.List;

public interface Relation {
    BinaryRelation intersection(BinaryRelation obj);          //перетин

    BinaryRelation union(BinaryRelation obj);                 //об'єднання

    BinaryRelation difference(BinaryRelation obj);            //різниця

    BinaryRelation symmetricDifference(BinaryRelation obj);  //симетрична різниця

    BinaryRelation addition();                                //доповнення

    BinaryRelation transpose();                                    //обернення

    BinaryRelation composition(BinaryRelation obj);           //композиція

    BinaryRelation composition(BinaryRelation obj, Integer power);           //композиція

    BinaryRelation narrowing(int x);                          //звуження

    boolean isPartOf(BinaryRelation relation);

    boolean isReflective();

    boolean isAntiReflective();

    boolean isSymmetric();

    boolean isAsymmetric();

    boolean isAntisymmetric();

    boolean isTransitive();

    boolean isAcyclic();

    boolean isConnected();

    boolean isTolerant();

    boolean isEquivalent();

    boolean isQuasiOrder();

    boolean isOrder();

    boolean isStrictOrder();

    boolean isLinearOrder();

    boolean isStrictLinearOrder();

    BinaryRelation reach();

    BinaryRelation mutualReach();

    BinaryRelation transitiveClosure();

    /**
     * Ignorant relation
     *
     * @return symmetric part
     */
    BinaryRelation symmetricPart();

    /**
     * Dominant relation
     *
     * @return asymetric part
     */
    BinaryRelation asymmetricPart();

    List<FactorizationClass> getClassesForFactorization(int[][] matrix);

    BinaryRelation relationFactorization();

    BinaryRelation relationFactorization(int[][] matrix);


    void printRelationType();

    BinaryRelation disparity();

    Double findDistance(BinaryRelation binaryRelation);

}
