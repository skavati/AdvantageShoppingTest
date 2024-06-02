cls
cd .\
$CurrentDir = (Get-Item -Path .\).FullName
Write-Output "current directory: "$CurrentDir
function Get-ParentPath {
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

$project = Get-ParentPath $CurrentDir
Write-Output "Project Path: "$project