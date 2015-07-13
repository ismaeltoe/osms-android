package com.github.ismaeltoe.osms.sample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.ismaeltoe.osms.library.Osms;
import com.github.ismaeltoe.osms.library.entities.error.CommonErrorEntity;
import com.github.ismaeltoe.osms.library.entities.contract.ContractEntity;
import com.github.ismaeltoe.osms.library.entities.CredentialsEntity;
import com.github.ismaeltoe.osms.library.entities.error.PolicyRequestErrorEntity;
import com.github.ismaeltoe.osms.library.entities.error.ServiceRequestError;
import com.github.ismaeltoe.osms.library.entities.error.ServiceRequestErrorEntity;
import com.github.ismaeltoe.osms.library.entities.messaging.MessageEntity;
import com.github.ismaeltoe.osms.library.entities.purchase.PurchaseEntity;
import com.github.ismaeltoe.osms.library.entities.statistic.StatisticEntity;
import com.github.ismaeltoe.osms.library.services.ContractsService;
import com.github.ismaeltoe.osms.library.services.CredentialsService;
import com.github.ismaeltoe.osms.library.services.MessagingService;
import com.github.ismaeltoe.osms.library.services.PurchaseHistoryService;
import com.github.ismaeltoe.osms.library.services.StatisticsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {

        final Osms osms = new Osms(Constants.CLIENT_ID, Constants.CLIENT_SECRET);
        osms.setAccessToken(Constants.ACCESS_TOKEN);

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final TextView accessTokenView = (TextView) v.findViewById(R.id.accessToken);
        Button gAccessTokenView = (Button) v.findViewById(R.id.gAccessToken);

        final TextView contractsView = (TextView) v.findViewById(R.id.contracts);
        Button gContractsView = (Button) v.findViewById(R.id.gContracts);

        final TextView purchaseHistoryView = (TextView) v.findViewById(R.id.purchaseHistory);
        Button gPurchaseHistoryView = (Button) v.findViewById(R.id.gPurchaseHistory);

        final TextView statisticsView = (TextView) v.findViewById(R.id.statistics);
        Button gStatisticsView = (Button) v.findViewById(R.id.gStatistics);

        final TextView sendMessageView = (TextView) v.findViewById(R.id.sendMessage);
        Button gSendMessageView = (Button) v.findViewById(R.id.gSendMessage);

        gAccessTokenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CredentialsService credentialsService = osms.credentials();

                credentialsService.getAccessToken("client_credentials", new Callback<CredentialsEntity>() {
                    @Override
                    public void success(CredentialsEntity credentialsEntity, Response response) {
                        osms.setAccessToken(credentialsEntity.getAccessToken());
                        accessTokenView.setText(gson.toJson(credentialsEntity));
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        accessTokenView.setText(retrofitError.getMessage());
                        Log.e(TAG, retrofitError.getMessage());
                    }
                });
            }
        });

        gContractsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractsService contractsService = osms.contracts();

                contractsService.getContracts(Constants.COUNTRY, new Callback<ContractEntity>() {
                    @Override
                    public void success(ContractEntity contractEntity, Response response) {
                        contractsView.setText(gson.toJson(contractEntity));
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        CommonErrorEntity e = (CommonErrorEntity) retrofitError.getBodyAs(CommonErrorEntity.class);
                        contractsView.setText(e.toString());
                        Log.e(TAG, e.toString());
                    }
                });
            }
        });

        gPurchaseHistoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PurchaseHistoryService purchaseHistoryService = osms.purchaseHistory();

                purchaseHistoryService.getPurchaseOrders(null, new Callback<PurchaseEntity>() {
                    @Override
                    public void success(PurchaseEntity purchaseEntity, Response response) {
                        purchaseHistoryView.setText(gson.toJson(purchaseEntity));
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        CommonErrorEntity e = (CommonErrorEntity) retrofitError.getBodyAs(CommonErrorEntity.class);
                        purchaseHistoryView.setText(e.toString());
                        Log.e(TAG, e.toString());
                    }
                });
            }
        });

        gStatisticsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatisticsService statisticsService = osms.statistics();

                statisticsService.getStatistics(null, null, new Callback<StatisticEntity>() {
                    @Override
                    public void success(StatisticEntity statisticEntity, Response response) {
                        statisticsView.setText(gson.toJson(statisticEntity));
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        CommonErrorEntity e = (CommonErrorEntity) retrofitError.getBodyAs(CommonErrorEntity.class);
                        statisticsView.setText(e.toString());
                        Log.e(TAG, e.toString());
                    }
                });
            }
        });

        gSendMessageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessagingService messagingService = osms.messaging();

                messagingService.sendMessage(
                        Constants.SENDER_ADDRESS,
                        Constants.MESSAGE_ENTITY,
                        new Callback<MessageEntity>() {
                            @Override
                            public void success(
                                    MessageEntity messageEntity,
                                    Response response) {
                                sendMessageView.setText(gson.toJson(messageEntity));
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {
                                ServiceRequestErrorEntity serviceRequestErrorEntity = null;
                                PolicyRequestErrorEntity policyRequestErrorEntity = null;

                                try {
                                    serviceRequestErrorEntity =
                                            (ServiceRequestErrorEntity)
                                                    retrofitError.getBodyAs(ServiceRequestError.class);
                                } catch (RuntimeException e) {
                                    Log.e(TAG, e.getMessage());
                                }

                                try {
                                    policyRequestErrorEntity =
                                            (PolicyRequestErrorEntity)
                                                    retrofitError.getBodyAs(PolicyRequestErrorEntity.class);

                                } catch (RuntimeException e) {
                                    Log.e(TAG, e.getMessage());
                                }

                                if (serviceRequestErrorEntity != null) {
                                    sendMessageView.setText(gson.toJson(serviceRequestErrorEntity));
                                } else {
                                    sendMessageView.setText(gson.toJson(policyRequestErrorEntity));
                                }
                            }
                        }
                );
            }
        });
    }
}
