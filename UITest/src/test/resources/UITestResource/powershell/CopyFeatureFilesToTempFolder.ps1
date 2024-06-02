cls
cd .\
# ------------------- Get Project Path -------------------------

$project = (Get-Item -Path ".\").FullName
<#function Get-ParentPath {
    param([string]$Path)

    $Parent = $Path
    [array]$Parents = $Parent

    while(($Parent = Split-Path $Parent -Parent)){
        $Parents += $Parent
        if((Get-Item -Path $Parent ).Name -eq "src") {
        #to return parent of 'src' which is current project
        return Split-Path $Parent -Parent
        }
    }

}

#To get project full path
$project = Get-ParentPath $CurrentDir #>

Write-Output "Project path: "+$project

# ------------------- Get Project Path END -------------------------

# ------------------- Get Feature Order Directory (temp folder) from Config.xml -------------------------

$configXmlFiles = Get-ChildItem $project -Filter *.xml -Recurse | % { $_.FullName }
 ForEach ($configXmlFile in $configXmlFiles)
 { 
 if ($configXmlFile.Contains("config\") -and ($configXmlFile.Contains("resources")))
  { 
   $configXmlContent = [xml](Get-Content $configXmlFile)
   Write-Output "config.xml file full path: "+$configXmlFile
   }
 }
$tempFolder=$configXmlContent.config.FeatureOrderDir
if ($tempFolder.Contains("{user_home}"))
{
$tempFolder =   $tempFolder -replace "{user_home}","$env:USERPROFILE"
}
Write-Output "Temp Folder full path: "+$tempFolder

#$tempFolder = "C:\Users\c70032.CLIENT\temp\X\FeatureOrder_MBankWeb"

# ------------------- Get Feature Order Directory (temp folder) from Config.xml END-------------------------

# ------------------- Copy feature files into temp Folder -------------------------

# delete temporary folder 'FeatureOrder_MBankWeb' if exists
if( (Test-Path -Path $tempFolder) )
{
   Remove-Item $tempFolder -Recurse
}
#create temporary folder after deletion
New-Item -ItemType Directory -Force -Path $tempFolder
$files = Get-ChildItem $project -Filter *.feature -Recurse | % { $_.FullName }
#Write-Host $files
#$files=$($files -split ".feature ")
#$files = $($files -split "`r`n")
$TxtFiles = Get-ChildItem $project -Filter *.txt -Recurse | % { $_.FullName }
 $j=0
 ForEach ($TxtFile in $TxtFiles)
 {  
 if ($TxtFile.Contains("featurelist") -and ($TxtFile.Contains("resources")))
 { 
 $j++
   $content = Get-Content $TxtFile
   Write-Output "Feature list text file full path: "+$TxtFile   
    #$tempFolderName = Split-Path $tempFolder -Leaf 
   #$newTempFolderName = $tempFolderName+[int]($j-1)
   #$parentFullpath = Split-Path -Path $tempFolder
   #$newTempFolder  = $parentFullpath+"\"+$newTempFolderName
   #Write-Output "New tempFolder full path: "+$newTempFolder
   # delete temporary folder 'FeatureOrder_MBankWeb' if exists
#if( (Test-Path -Path $newTempFolder) )
#{
 #  Remove-Item $newTempFolder -Recurse
#}
#create temporary folder after deletion
#New-Item -ItemType Directory -Force -Path $newTempFolder
   
     $i=0
foreach ($line in $content)
{
   $i++
   #if line starts with any white space then trim it first
   $line = $line.Trim()
   #if each line in txt file is empty or starting with # then go to next line
   if($line.StartsWith("#")){continue} 
   # Write-Host $line
   ForEach ($file in $files){   
    if ($file.Contains($line) -and ($file.Contains("resources"))){   
    #Write-host $file;    
    #copy each feature file from project to temporary folder 'FeatureOrder_MBankWeb'
    #with feature files renamed
    # to format number to make 4 digit 
    $num="{0:D4}" -f $i
    Copy-Item $file ($tempFolder+"\"+$num+"_"+"$line")
    }
}
} 
   
   
   
   }
 }
 


# ------------------- Copy feature files into temp Folder End-------------------------