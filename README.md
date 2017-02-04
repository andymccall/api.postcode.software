# Postcode.software

Query for UK postcodes over HTTP and HTTPS. Postcode.software uses the Post Office sample PAF file.

Documentation for the API can be found at [Swagger](https://app.swaggerhub.com/api/andymccall/api.postcode.software/1.0.0).

### Build Status and Test Coverage
[![Build Status](https://travis-ci.org/andymccall/api.postcode.software.svg?branch=master)](https://travis-ci.org/andymccall/api.postcode.software)
[![Coverage Status](https://coveralls.io/repos/github/andymccall/api.postcode.software/badge.svg?branch=master)](https://coveralls.io/github/andymccall/api.postcode.software?branch=master)


A demo of this service can be found at:

  [http://api.postcode.software/](http://api.postcode.software/)
& [https://api.postcode.software/](https://api.postcode.software/)
  
 Currently working API endpoints are:
 
    * ping
    * postcode/<postcode>
    * postcode/<postcode>/<building_no>
    * validate/<postcode>
    * validate/<postcode>/<building_no>
    * random
    * random/<number_of_random_records_to_return>
    * udprn/<udprn>
 
 The service uses the sample PAF file from the Post Office which does not have all addresses in it, to test use /random or /random/<number> to return valid postcodes.
