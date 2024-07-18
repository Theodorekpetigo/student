package com.verimsolution.schoolinfo.controllers.students

import com.verimsolution.schoolinfo.responses.HttpResponse
import com.verimsolution.schoolinfo.services.PostService
import com.verimsolution.schoolinfo.utils.STUDENT_API_BASE_URL
import com.verimsolution.schoolinfo.utils.successResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(STUDENT_API_BASE_URL + "posts", produces = [MediaType.APPLICATION_JSON_VALUE])
class StudentPostController (
    private val service: PostService
) {

    @GetMapping
    fun index(): ResponseEntity<HttpResponse> = successResponse(
        "List posts", HttpStatus.OK, service.listAllPost()
    )

    @GetMapping("lasted")
    fun lastedPost(@RequestParam limit: Int): ResponseEntity<HttpResponse> = successResponse(
        "List posts", HttpStatus.OK, service.limitedPost(limit)
    )

    @GetMapping("{id}")
    fun showPost(@PathVariable id: String): ResponseEntity<HttpResponse> = successResponse(
        "Post details", HttpStatus.OK, service.showPost(id)
    )
}