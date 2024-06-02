cls
cd .\
# delete folder 'IBResource' if exists
if( (Test-Path -Path "IBResource") )
{
   Remove-Item "IBResource" -Recurse
}
#create folder IBResource\config
$configDir=".\IBResource\config"
#create folder IBResource\data
$dataDir=".\IBResource\data"
#create folder IBResource\featurelist
$featurelistDir=".\IBResource\featurelist"
#create data,config and featurelist directories
New-Item -ItemType Directory -Force -Path $configDir
New-Item -ItemType Directory -Force -Path $dataDir
New-Item -ItemType Directory -Force -Path $featurelistDir
# to get TestDataFile name from config.xml
$configXml = [xml](Get-Content .\config.xml)
$TestDataFile=$configXml.config.TestDataFile
#To copy TestDataFile to IBResource\data
Copy-Item ".\$TestDataFile" $dataDir
#To copy config.xml to IBResource\config
Copy-Item ".\config.xml" $configDir
#To copy config.xml to IBResource\config
Copy-Item ".\FeatureList_IBank.txt" $featurelistDir
$configFile="$configDir\config.xml"
$dataFile="$dataDir\$TestDataFile"
$featurelistFile="$featurelistDir\FeatureList_IBank.txt"

Write-Progress -Activity "Copying files to JAR in Progress..."
#to copy IBResource\config\config.xml and IBResource\data\testDataFile to JAR
cmd /c jar uf IBank-0.0.1-SNAPSHOT-jar-with-dependencies.jar $dataFile $configFile $featurelistFile
Write-Progress -Activity "Completed"

if( (Test-Path -Path "IBResource") )
{
   Remove-Item "IBResource" -Recurse
}