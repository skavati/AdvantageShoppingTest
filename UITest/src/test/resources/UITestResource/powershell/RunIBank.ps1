cls
cd .\
$configXml = [xml](Get-Content .\config.xml)
$OrderDir=$configXml.config.FeatureOrderDir
$OrderDirMod =   $OrderDir -replace "{user_home}","$env:USERPROFILE"
$OrderDirMod 
try
{
  cmd /C mvn install "-Dcucumber.options=--tags @RunOrder"
  if ($LASTEXITCODE -ne "0")
  {
       throw ("Exception in creating temporary directory of feature files - exit code:$LASTEXITCODE")
  }
  Write-Host "*** IBank run in progress... *** "

  cmd /C mvn install "-Dcucumber.options=$OrderDirMod"
  if ($LASTEXITCODE -ne "0")
  {
             throw ("Exception in processing IBank run - exit code:$LASTEXITCODE")
  }
  Write-Host "*** IBank run completed *** "
}
catch [System.Exception]
{
       Write-Error("`r`n*** EXCEPTION in RunIBank.ps1 *** with error:`r`n$Error[0]`r`n")
}
finally
{
  if (($LASTEXITCODE -eq "0") -or ($LASTEXITCODE -eq $null) -or ($LASTEXITCODE -match ""))
  {
             Write-Host("`r`n*** RunIBank.ps1 - completed $(Get-Date -format 'G') ***")
  }
  else
  {
             Write-Host("`r`n*** ERROR in RunIBank.ps1 *** with error: $LASTEXITCODE $(Get-Date -format 'G') `r`n")
  }
} 