echo "starting script"
cd D:\ATAF_Projects\ATAF_Demo
mvn clean test -Dcucumber.options="--tags @PaymentRequestTest"
echo "ending script"
pause