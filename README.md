[![Build Status](https://travis-ci.org/ItaySharon/Crypton.svg?branch=master)](https://travis-ci.org/ItaySharon/Crypton)
# Crypton
Encrypted data saving API
> note: the program isn't finished yet and can only do 2 things:
> * `Crypton.jar` - create cged file called test.cged which have:
>  * header - contains data like parse version, author, type, etc...
>  * body - contains the data (encrypted)
>  * checksum - checks if the data is valid
> * `Verbose.jar` - load test.cged and do:
>  * print parsed data (not decrypted)
>  * validate data from checksum

## how to compile?
* make sure that you have ant:
 * ~~Windows:~~ `W.I.P`
 * Linux: `./compile.sh`
