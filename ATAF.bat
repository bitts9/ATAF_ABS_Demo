echo "starting script"
cd D:\ATAF_Projects\ATAF_Demo
mvn clean install -Dcucumber.options="--tags @PaymentRequest"
echo "ending script"
pause