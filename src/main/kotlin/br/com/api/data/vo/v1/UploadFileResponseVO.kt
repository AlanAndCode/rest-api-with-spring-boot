package br.com.api.data.vo.v1

class UploadFileResponseVO (
    var fileName: String = "",
    var fileDownloadUri: String = "",
    var fileType: String = "",
    var fileSize: Long = 0
)