Втора лабораториска вежба по Софтверско инженерство
Andreja Dimkovski 195041

2. CFG Дијаграм
   

3. Цикломатска комплексност
Цикломатската комплесност може да се пресмета со V(G) = E - N + 2, каде што E е број на ребра и N е број на јазли на CFG.
V(G) = 42 - 32 + 2 = 12

4. Every Branch критериум


Објаснување за напишаните тестови
Има 6 тестови 
Тест случај  1: allItems = [null] , payment = 500
Се праќа празна листа и се очекува да се фрли искличок бидејќи листата е празна “allItems list can’t be null!”.

Тест случај 2: allItems = [new Item(null,null,500,0)] , payment = 500
Се праќа листа која содржи null елементи за име и баркод при што се очекува да се фрли исклучок бидејќи нема баркод “No barcode!” .


Tест случај 3: allItems = [new Item(null,”123456789”,500,0)] , payment = 500
Се праќа листа која содржи null елементи за име при што се очекува да врати Тrue бидејќи името се поставува на ‘unknown’, баркодот е валиден , нема попуст и сумата е еднаква на крајната сметка за плаќање. 



Тест случај 4: allItems = [new Item(Item1,”123456789”,500,0)] , payment = 400
Се праќа листа која ги има сите елементи како што се име , валиден баркод , цена, нема попуст , но сумата е помала од крајната сметка за плаќање при што очекуваниот резултат што треба да се врати ќе биде False.

Тест случај 5: allItems = [new Item(Item2,”012345678”,500,0.1f)] , payment = 500
Се праќа листа која ги има сите елементи како што се име , валиден баркод  , цена, има попуст бидејќи цената на призводот е поголема од 300 и баркодот почнува со 0 се применува попуст при што очекуваниот резултат што треба да се врати ќе биде True.

Тест случај 6: allItems = [new Item(Item3,”01234567-2”,500,0.1f)] , payment = 500
Се праќа листа која ги има сите елементи како што се име , не валиден баркод  , цена, има попуст , бар код кој има непознат карактер од дефинираното , се очекува да се фрли исклучок “Invalid character in item barcode!”.

5. Multiple Condition критериум за метод
Има 8 тест случаи:
Тест случај 1: Т Т Т
Кога сите три услови се исполнети.
 allItems=[new Item(“Item1”,”0123456789”,400,0.1f)] , payment = 500, цената е поголема од 300 ,  попустот е поголем од 0 и баркодот има ‘0’, износот се намалува.
Тест случај 2: Т Т F
Кога првите два услови се исполнети а последниот услов не. 
allItems=[new Item(“Item1”,”1123456789”,400,0.1f)] , payment = 500, цената е поголема од 300 ,   попустот е поголем од 0 и баркодот нема ‘0’, износот не се намалува.
Тест случај 3: Т F T
Кога првиот и последниот услов се исполнети а вториот услов не. 
allItems=[new Item(“Item1”,”0123456789”,400,0.0f)] , payment = 500, цената е поголема од 300 попустот не е поголем од 0 и баркодот има ‘0’, износот не се намалува.
Тест случај 4: Т F F
Кога првиот  услов е исполнет а вториот и третиот услов не.
allItems=[new Item(“Item1”,”1123456789”,400,0.0f)] , payment = 500, цената е поголема од 300 но попустот не е поголем од 0 и баркодот нема ‘0’ , износот не се намалува.
 Тест случај 5: F T T
Кога првиот  услов не е исполнет а вториот и третиот услов се исполнети.
allItems=[new Item(“Item1”,”0123456789”,200,0.1f)] , payment = 500, цената е помала од 300 , попустот е поголем од 0 и баркодот има ‘0’, износот не се намалува.
Тест случај 6: F T F
Кога првиот и третиот  услов не се исполнети а вториот  услов е исполнет.
allItems=[new Item(“Item1”,”1123456789”,200,0.1f)] , payment = 500, цената е помала од 300, попустот е поголем од 0 и баркодот нема ‘0’, износот не се намалува.
Тест случај 7: F F T
Кога првиот и вториот  услов не се исполнети а третиот  услов е исполнет.
allItems=[new Item(“Item1”,”0123456789”,200,0.0f)] , payment = 500, цената е помала од 300, попустот не е поголем од 0 и баркодот има ‘0’, износот не се намалува.
Тест случај 8: F F F
Кога сите три услови не се исполнети.
allItems=[new Item(“Item1”,”1123456789”,200,0.0f)] , payment = 500, цената е помала од 300, попустот не е поголем од 0 и баркодот нема ‘0’, износот не се намалува.











	



