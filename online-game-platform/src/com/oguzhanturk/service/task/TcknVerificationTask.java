package com.oguzhanturk.service.task;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

import com.oguzhanturk.db.OnMemoryDatabase;
import com.oguzhanturk.entity.user.User;
import com.oguzhanturk.repository.UserRepository;
import com.oguzhanturk.util.logger.FileLogger;
import com.oguzhanturk.util.logger.Logger;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class TcknVerificationTask implements Runnable {

	private long tCKN;
	private String name;
	private String surname;
	private int birthyear;
	private User user;
	private UserRepository repository;
	private final Pattern TCKN_VALID_PATTERN = Pattern.compile("[0-9]{11}");
	private static final Logger LOGGER = new FileLogger(TcknVerificationTask.class);

	public TcknVerificationTask(User user, UserRepository repository) {
		if (validateTCKN(user.gettCKN())) {
			this.tCKN = Long.parseLong(user.gettCKN());
		}
		this.user = user;
		this.name = user.getName();
		this.surname = user.getSurname();
		this.birthyear = user.getDateOfBirth().getYear();
		this.repository = repository;
	}

	@Override
	public void run() {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		try {
			boolean verification = kpsPublicSoapProxy.TCKimlikNoDogrula(tCKN, name, surname, birthyear);
			if (!verification) {
				LOGGER.log("Tckn = " + tCKN + " name : " + name + " " + surname + " cannot be verified");
//				OnMemoryDatabase.USERS.remove(id);
			} else {
				repository.save(user);
				LOGGER.log("addUser -> " + user.getId() + " added");
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private boolean validateTCKN(String tCKN) {
		return TCKN_VALID_PATTERN.matcher(tCKN).matches();
	}

}
