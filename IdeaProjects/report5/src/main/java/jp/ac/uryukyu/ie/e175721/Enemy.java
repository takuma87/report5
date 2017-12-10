package jp.ac.uryukyu.ie.e175721;

public class Enemy extends LivingThing {


    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    public void attack(LivingThing opponent){
        if (isDead() == false) {
            int damage = (int) (Math.random() * getAttack());
            int val = (int) (Math.random() * 10);
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            } else if (val == 0 || val == 1 || val == 2 ) {
                damage = damage*2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            } else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            }
        }
    }





    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() < 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

}