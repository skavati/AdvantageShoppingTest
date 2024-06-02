cls
Get-ChildItem "D:\CompassTestAutomation\TestReport\Extent\IBank" -Filter *.html | 
Foreach-Object {
    $content = Get-Content $_.FullName
    #echo "File name "+$_
   if ($content -match 'file:///D:\\CompassTestAutomation\\TestReport\\Extent\\IBank') {
   ($content) |
    ForEach-Object {$_ -replace 'file:///D:\\CompassTestAutomation\\TestReport\\Extent\\IBank', '.'} |
    Set-Content $_.FullName
    echo "Screenshot path has been amended in "+$_
   } 
}