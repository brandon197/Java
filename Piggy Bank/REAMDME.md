OwnedPiggyBank

A class representing a piggy bank that has an owner. A piggy bank owns a collection (or possibly collections) of coins, but does not own 
the coins themselves. In other words, the piggy bank and its collection of coins form a composition.
Only the owner of the piggy bank is able to remove coins from the piggy bank. The piggy bank does not own its owner. 
In other words, the piggy bank and its owner form an aggregation.

Coin

A class that represents Canadian coins. Each coin object represents a value that is equal to one of the static fields. Each static
field has a value that equal to its equivalent value in canadian coins. I.e. QUARTER is equal to 25. 

Owner

An owner of some item. Every owner has a name and a unique long identification number.
