package lab01;

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
    BinaryRelation symmetricPart();
    BinaryRelation asymmetricPart();
    BinaryRelation relationFactorization();


}
