package quyenvvph20946.fpl.geoteachapplication.view.fragment;



public class FragmentFavorite extends Fragment {
    private FragmentFavoriteBinding binding;
    ProductFavoriteAdapter adapter;

    List<ProductFind> list;



    @NonNull
    public static FragmentFavorite newInstance() {
        FragmentFavorite fragment = new FragmentFavorite();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(  @Nullable LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initController();
    }

    private void initController() {
        binding.imgChat.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ChatActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slidle_in_left, R.anim.slidle_out_left);
        });
    }


    public  void initView(){
        list = new ArrayList<>();
        for(int i = 0; i<10 ; i++){
            list.add(new ProductFind("Điện thoại "+ i, "https://res.cloudinary.com/dwxavjnvc/image/upload/v1699708633/Product/csddbopt4d1xeeivy8bc.png"));
        }
        adapter = new ProductFavoriteAdapter(getContext(), list);
        binding.recycleView.setAdapter(adapter);
    }
}