package com.project.admin.service;



import com.project.admin.entity.AdminEntity;
import com.project.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity saveAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<AdminEntity> getAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    public AdminEntity updateAdmin(Long adminId, AdminEntity updatedAdmin) {
        return adminRepository.findById(adminId)
                .map(admin -> {
                    admin.setAdminName(updatedAdmin.getAdminName());
                    admin.setAdminStatus(updatedAdmin.getAdminStatus());
                    admin.setApprovedLoans(updatedAdmin.getApprovedLoans());
                    return adminRepository.save(admin);
                })
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + adminId));
    }

    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }
}
