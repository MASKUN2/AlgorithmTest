class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int fullCastingTime = bandage[0];
        int currentCastingTime = 0;
        int recoveryPerSec = bandage[1];
        int recoveryBonus = bandage[2];
        
        int currentTime = 0;
        int currentHealth = health;
        
        int currentAttackInning = 0;
        int endAttackInning = attacks.length - 1;
        
        while(true){
            currentTime ++;
            System.out.println("currentTime=" +currentTime);
            
            boolean interrupted = false;
            
            int attackTime = attacks[currentAttackInning][0];
            int attackDamage = attacks[currentAttackInning][1];
            if(attackTime == currentTime){
                currentHealth -= attackDamage;
                currentCastingTime = 0;
                currentAttackInning++;
                interrupted = true;
            }
            System.out.println("currentHealth="+ currentHealth);

            
            if(currentHealth <= 0){
                return -1;
            }
            
            if(currentAttackInning > endAttackInning){
                return currentHealth;
            }
            
            if(interrupted){
                continue;
            }
            
            currentCastingTime ++;
            currentHealth += recoveryPerSec;
            if(currentCastingTime == fullCastingTime){
                currentHealth += recoveryBonus;
                currentCastingTime = 0;
            }
            
            if(currentHealth > health){
                currentHealth = health;
            }
            System.out.println("currentHealth="+ currentHealth);
            
        }
    }
}