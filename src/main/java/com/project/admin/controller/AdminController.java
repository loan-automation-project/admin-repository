package com.project.admin.controller;



import com.project.admin.entity.AdminEntity;
import com.project.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity admin) {
        return ResponseEntity.ok(adminService.saveAdmin(admin));
    }

    @GetMapping
    public ResponseEntity<List<AdminEntity>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminEntity> getAdminById(@PathVariable Long adminId) {
        Optional<AdminEntity> admin = adminService.getAdminById(adminId);
        return admin.map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + adminId));
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<AdminEntity> updateAdmin(
            @PathVariable Long adminId,
            @RequestBody AdminEntity updatedAdmin) {
        return ResponseEntity.ok(adminService.updateAdmin(adminId, updatedAdmin));
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) {
        adminService.deleteAdmin(adminId);
        return ResponseEntity.noContent().build();
    }
}