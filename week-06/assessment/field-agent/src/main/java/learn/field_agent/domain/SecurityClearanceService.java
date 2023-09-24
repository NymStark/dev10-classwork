package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityClearanceService {
    private final SecurityClearanceRepository repository;

    public SecurityClearanceService(SecurityClearanceRepository repository) {
        this.repository = repository;
    }

    public SecurityClearance findById(int securityClearanceId) {

        return repository.findById(securityClearanceId);
    }

    public List<SecurityClearance> findAll() {
        return repository.findAll();
    }

    public Result<SecurityClearance> add(SecurityClearance securityClearance) {
        Result<SecurityClearance> result = validate(securityClearance);
        if (!result.isSuccess()) {
            return result;
        }

        // Check for duplicate name, needed findByName() method to validate.
        if (repository.findByName(securityClearance.getName()) != null) {
            result.addMessage("This security clearance exists.", ResultType.INVALID);
            return result;
        }

        if (securityClearance.getSecurityClearanceId() != 0) {
            result.addMessage("Cannot set security clearance ID for 'add' operation", ResultType.INVALID);
            return result;
        }

        SecurityClearance addedSecurityClearance = repository.add(securityClearance);
        if (addedSecurityClearance != null) {
            result.setPayload(addedSecurityClearance);
        } else {
            result.addMessage("Failed to add Security Clearance.", ResultType.INVALID);
        }

        return result;
    }
    public Result<SecurityClearance> update(SecurityClearance securityClearance) {
        Result<SecurityClearance> result = validate(securityClearance);
        if (!result.isSuccess()) {
            return result;
        }
        SecurityClearance existingSecurityClearance = repository.findById(securityClearance.getSecurityClearanceId());

        // Check if the name is being changed to the same name
        if (existingSecurityClearance.getName().equals(securityClearance.getName())) {
            result.addMessage("You're not updating anything.", ResultType.INVALID);
            return result;
        }

        // Check if the name is being changed to a name that already exists
        if (repository.findByName(securityClearance.getName()) != null) {
            result.addMessage("Security Clearance name already exists.", ResultType.INVALID);
            return result;
        }

        if (securityClearance.getSecurityClearanceId() <= 0) {
            result.addMessage("Invalid Id", ResultType.INVALID);
            return result;
        }

        if (!repository.update(securityClearance)) {
            result.addMessage("Failed to update Security Clearance.", ResultType.INVALID);
        }

        return result;
    }

    public boolean deleteById(int securityClearanceId) {
        return repository.deleteById(securityClearanceId);
    }

    private Result<SecurityClearance> validate(SecurityClearance securityClearance) {
        Result<SecurityClearance> result = new Result<>();
        if (securityClearance == null) {
            result.addMessage("Security Clearance cannot be null.", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(securityClearance.getName())) {
            result.addMessage("Name is required for Security Clearance.", ResultType.INVALID);
        }

        return result;
    }
}
