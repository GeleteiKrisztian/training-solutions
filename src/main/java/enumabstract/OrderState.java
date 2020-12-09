package enumabstract;

public enum OrderState {
    NEW {
        boolean canDelete() {
            return true;
        }
    }, CONFIRMED {
        boolean canDelete() {
            return true;
        }
    }, PREPARED {
        boolean canDelete() {
            return true;
        }
    }, ONBOARD {
        boolean canDelete() {
            return false;
        }
    }, DELIVERED {
        boolean canDelete() {
            return false;
        }
    }, RETURNED {
        boolean canDelete() {
            return false;
        }
    }, DELETED {
        boolean canDelete() {
            return false;
        }
    };

    abstract boolean canDelete();

}
