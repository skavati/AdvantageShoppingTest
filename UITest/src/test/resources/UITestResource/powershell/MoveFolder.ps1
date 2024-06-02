cls
$ibank = "C:\Users\c70032.CLIENT\eclipse-workspace\IBank\src\main\java\IBank"
if( (Test-Path  $ibank) )
{
 Move-Item $ibank C:\Users\c70032.CLIENT\eclipse-workspace\IBank\src\test\java -force
 echo "Package IBank moved to test\java"
}else {
    echo "Package IBank doesn't exist"
}

$ibresource="C:\Users\c70032.CLIENT\eclipse-workspace\IBank\src\main\resources\IBResource"

if( (Test-Path $ibresource) )
{
 Move-Item  $ibresource C:\Users\c70032.CLIENT\eclipse-workspace\IBank\src\test\resources -force
 echo "IBResource moved to test\resource"
}else {
    echo "IBResource doesn't exist"
}

