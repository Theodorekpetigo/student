package com.verimsolution.schoolinfo.controllers.students

import com.verimsolution.schoolinfo.responses.HttpResponse
import com.verimsolution.schoolinfo.services.ClassroomService
import com.verimsolution.schoolinfo.utils.STUDENT_API_BASE_URL
import com.verimsolution.schoolinfo.utils.successResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(STUDENT_API_BASE_URL + "classrooms", produces = [MediaType.APPLICATION_JSON_VALUE])
class StudentClassroomController(
    private val service: ClassroomService
) {

    @GetMapping
    fun list(): ResponseEntity<HttpResponse> = successResponse(
        "List classroom", HttpStatus.OK, service.listClassroom()
    )
}